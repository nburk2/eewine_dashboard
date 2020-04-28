package dashboard.clientData

import com.amazonaws.services.s3.model.CannedAccessControlList
import grails.plugins.rest.client.RestBuilder
import grails.transaction.Transactional
import grails.util.Holders

@Transactional
class ClientTanksService {

    def config = Holders.config
//    def gatewayKey = config.GATEWAY_KEY
    def amazonS3Service
    def rest = new RestBuilder()

    def tanks = []

    def getTankImageUrl(key) {
        def resp = rest.get("https://ibkxdho8ce.execute-api.us-east-1.amazonaws.com/prod/gets3file?bucket=tank-images&key=" + key) {
            headers["x-api-key"] = gatewayKey
        }
        return resp.json.signedUrl
    }

    def uploadTankImage(file, tankId) {
        amazonS3Service.defaultBucketName = "tank-images"
        amazonS3Service.storeMultipartFile(tankId + file.name, file)
    }

    def deleteTankImage(tank) {
        amazonS3Service.defaultBucketName = "tank-images"
        def splitSlash = tank.imageUrl.split("/")
        def length = splitSlash.length
        def key = splitSlash[length - 1]
        amazonS3Service.deleteFile(key)
    }

    def uploadTanks(file) {
        file.inputStream.eachLine { line ->
            def lineSplit = line.split(',(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)', -1)
            tanks << lineSplit
        }
        createUpdateTanks()
    }

    def createUpdateTanks() {
//        static belongsTo = [account: ClientAccounts]
        tanks.each { tank ->
            if(tank[1] != "Account Name") {

                def account = ClientAccounts.findOrCreateByNumber(tank[2].trim().toInteger())
                account.name = tank[1].trim()

                account.hasErrors()
//                println("account num: " + tank[2].trim())
                account.save(flush:true)

//                def newTank = ClientTanks.findOrCreateByNumberAndAccount(tank[3].trim(), account)
                def newTank = new ClientTanks()
//                println "tank: " + tank
                newTank.account = account
                //        int number
                newTank.number = tank[3].trim()
                // timestamp removed from upload because of required date modifications
//                newTank.timeStamp = tank[0].trim()
                //        String address
                newTank.address = tank[4].trim()
                //        String location
                newTank.location = tank[5].trim()
                //        tank ownership
                newTank.tankOwnership = tank[6].trim()
                //        String serialNumber
                newTank.serialNumber = tank[7].trim()
                //        String manufacturer
                newTank.manufacturer = tank[8].trim()
                //        int size
                newTank.size = tank[9].trim().toInteger()
                //        String type
                newTank.type = tank[10].trim()
                //        String product
                newTank.product = tank[11].trim()
                //        boolean properlyLabeled
                newTank.properlyLabeled = tank[12].trim().toLowerCase().contains("y") ? true : false
                //        boolean tertiaryContainment
                newTank.tertiaryContainment = tank[13].trim().toLowerCase().contains("y") ? true : false
                //        boolean painted
                newTank.painted = tank[14].trim().toLowerCase().contains("y") ? true : false
                //        String color
                newTank.color = tank[15].trim()
                //        String paintCondition
                newTank.paintCondition = tank[16].trim()
                //        boolean wineEnergyLogo
                newTank.wineEnergyLogo = tank[17].trim().toLowerCase().contains("y") ? true : false
                //        String logoCondition
                newTank.logoCondition = tank[18].trim()
                //        String pumpType
                newTank.pumpType = tank[19].trim()
                //        String condition
                newTank.pumpCondition = tank[20].trim()
                //        String pumpPartNumber
                newTank.pumpPartNumber = tank[21].trim()
                //        int numberOfDispensers
                newTank.numberOfDispensers = tank[22].trim().toInteger()
                //        String nozzleType
                newTank.nozzleType = tank[23].trim()
                //        String hoseGaugeLength
                newTank.hoseGaugeLength = tank[24].trim()
                //        String filterType
                newTank.filterType = tank[25].trim()
                //        String filterPartNumber
                newTank.filterPartNumber = tank[26].trim()
                //        String filterCondition
                newTank.filterCondition = tank[27].trim()
                //        boolean ecogreen
                newTank.ecogreen = tank[28].trim().toLowerCase().contains("y") ? true : false
                //        String ecogreenSerialNumber
                newTank.ecogreenSerialNumber = tank[29].trim()
                //        boolean tankGauge
                newTank.tankGauge = tank[30].trim().toLowerCase().contains("y") ? true : false
                //        String comments
                newTank.comments = tank[31].trim()
                //        String picture
                newTank.imageUrl = tank[32].trim()

                newTank.hasErrors()
//                println "errors after tank check: " + newTank.errors
                newTank.save(flush:true)
            } else {
//                println "columns: " + tank
            }
        }
    }

    def findTanks(params) {
        def tanks = []
        def inputFieldsList = ["","Address","Location","Tank Ownership","Serial Number","Manufacturer","Size","Type","Product","Color","Paint Condition","Comments","Properly Labeled - YES","Properly Labeled - NO","Tertiary Containment - YES","Tertiary Containment - NO","Painted - YES","Painted - NO","Wine Energy Logo - YES","Wine Energy Logo - NO","Ecogreen - YES","Ecogreen - NO","Tank Gauge - YES","Tank Gauge - NO"]
        def inputFieldsListNames = ["","address","location","tankOwnership","serialNumber","manufacturer","size","type","product","color","paintCondition","comments", "properlyLabeled","properlyLabeled","tertiaryContainment","tertiaryContainment","painted","painted","wineEnergyLogo","wineEnergyLogo","ecogreen","ecogreen","tankGauge","tankGauge"]
        if(!params.inputField && !params.account && !params.inputFieldText) {
            return tanks
        }

        def inputFieldsIndex = inputFieldsList.indexOf(params.inputField)

        if(params.account) {
            def account = ClientAccounts.findById(params.account.toInteger())
            tanks = ClientTanks.findAllByAccount(account)
        }

        if(inputFieldsIndex > 0 && inputFieldsIndex <= 11) {
            def tankIds = tanks.id.toString().replace("[","(").replace("]",")")
            tanks = ClientTanks.findAll("from ClientTanks Where ${inputFieldsListNames[inputFieldsIndex]} LIKE '%${params.inputFieldText}%' AND id IN " + tankIds)
        } else if(inputFieldsIndex > 11) {
            //odd number is true - YES
            //even number is false - NO
            def boolValue = true
            if (inputFieldsIndex % 2 != 0) {
                boolValue = false
            }

            def tankIds = tanks.id.toString().replace("[","(").replace("]",")")
            tanks = ClientTanks.findAll("from ClientTanks Where ${inputFieldsListNames[inputFieldsIndex]} = ${boolValue} AND id IN " + tankIds)
        }

        return tanks
    }
}
