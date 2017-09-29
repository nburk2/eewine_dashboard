package dashboard.data

import grails.converters.JSON
import grails.transaction.Transactional
import grails.plugins.rest.client.RestBuilder

@Transactional
class DriverAccountService {

    def rest = new RestBuilder()
    def driversMap = [:]

    def optimizeRoutes(locationList) {
        println "at method"
        def locations = locationList
        def resp = rest.post("https://api.routexl.nl/tour") {
            auth("nburk", "VhG1dzH@*Sll2BL3&PtwLE!I")
            accept("application/json")
            contentType("application/x-www-form-urlencoded")
            body("locations=" + (locations as JSON).toString())
        }
        def data = resp
        println data.json
    }

    def getGeolocation(address) {
        //key AIzaSyC9hB2bLGWefx0WOnzWzus_TfwnnWUQePE
        def key = "AIzaSyC9hB2bLGWefx0WOnzWzus_TfwnnWUQePE"
        def resp = rest.get("https://maps.googleapis.com/maps/api/geocode/json?key=" + key + "&address=" + address)
        return resp.json.results[0].geometry
    }

    def getAddresses() {
        def addressList = [
//                "9108 Centreville Rd, Manassas, VA 20110",
                "8848 whitchurch court, bristow, virginia",
                "4215 Winchester Rd, Marshall, VA 20115",
                "4661 Sudley Rd, Catharpin, VA 20143",
                "6417 Lee Hwy, Warrenton, VA 20187"
        ]
        def geolocations = [[address:"Start", lat:"38.757572", lng:"-77.4646612"]]
        addressList.each { address ->
            def location = getGeolocation(address)
            geolocations << [address:address,lat:location.location.lat,lng:location.location.lng]
        }
        geolocations << [address:"End", lat:"38.757572", lng:"-77.4646612"]
        println geolocations
        optimizeRoutes(geolocations)
        geolocations
    }

    def uploadDriverAccounts(file) {
        file.inputStream.eachLine { line ->
            def lineSplit = line.split(',')
            extractLineContent(lineSplit)
        }
        DriverAccount.executeUpdate('delete from DriverAccount')
        createDriverAccounts()
    }

    def extractLineContent(line) {
        def length = line.length
        def index = 0
        line.each { section->
            if(section && (index + 1) < length && line[index + 1]) {
                if(driversMap."${line[index + 1]}") {
                    driversMap."${line[index + 1]}" << section
                } else {
                    driversMap."${line[index + 1]}" = [section]
                }
            }
            index++
        }
    }

    def createDriverAccounts() {
        driversMap.each { driver ->
//            driver.value.each {
//                def account = new Account(name:it)
//                account.save(flush:true)
//            }
            def firstLast = driver.key.toString().split(" ")
            def firstName = firstLast[0]
            def lastInit = firstLast[1][0]
//            def newDriver = new Driver(firstName: firstLast[0], lastName:firstLast[1].substring(0))
//            newDriver.save(flush:true)

            def findDriver = Driver.findByFirstNameAndLastNameIlike(firstName, lastInit + "%")
            def accountList = Account.findAllByNameInList(driver.value)
            def driverAccount = DriverAccount.findByDriver(findDriver)
            if(!driverAccount) {
                driverAccount = new DriverAccount(driver: findDriver, accounts: accountList)
            } else {
                driverAccount.accounts = accountList
            }
            driverAccount.save(flush:true)
        }
    }
}
