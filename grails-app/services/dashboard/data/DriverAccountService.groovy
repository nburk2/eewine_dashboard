package dashboard.data

import grails.converters.JSON
import grails.transaction.Transactional
import grails.plugins.rest.client.RestBuilder

@Transactional
class DriverAccountService {

    def rest = new RestBuilder()
    def driversMap = [:]

    def uploadDriverAccounts(file) {
        file.inputStream.eachLine { line ->
            def lineSplit = line.split(',')
            extractLineContent(lineSplit)
        }
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
