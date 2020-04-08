package dashboard.clientData

import grails.transaction.Transactional

@Transactional
class ClientTanksService {

    def tanks = []

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

                account.save(flush:true)

                def newTank = ClientTanks.findOrCreateByNumberAndAccount(tank[3].trim(), account)

                newTank.account = account
                //        int number
                newTank.number = tank[3].trim()
                // timestamp
                newTank.timeStamp = tank[0].trim()
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
                //        boolean propertyLabeled
                newTank.propertyLabeled = tank[12].trim().toLowerCase().contains("y") ? true : false
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
                println "tank: " + tank
//                println "errors after tank check: " + newTank.errors
                newTank.save(flush:true)
            } else {
//                println "columns: " + tank
            }
        }
    }

    def findTanks(params) {
        def tanks = []
        def trueFalseList = ["","Property Labeled","Tertiary Containment","Painted","Wine Energy Logo","Ecogreen","Tank Gauge"]
        def inputFieldsList = ["","Address","Location","Tank Ownership","Serial Number","Manufacturer","Size","Type","Product","Color","Paint Condition","Number Of Dispensers","Comments"]
        def trueFalseListNames = ["", "propertyLabeled","tertiaryContainment","painted","wineEnergyLogo","ecogreen","tankGauge"]
        def inputFieldsListNames = ["","address","location","tankOwnership","serialNumber","manufacturer","size","type","product","color","paintCondition","numberOfPumps","numberOfDispensers","comments"]
        if(!params.booleanField && !params.inputField && !params.account && !params.inputFieldText) {
            return tanks
        }

        def booleanIndex = trueFalseList.indexOf(params.booleanField)
        def inputFieldsIndex = inputFieldsList.indexOf(params.inputField)

        if(params.account) {
            def account = ClientAccounts.findById(params.account.toInteger())
            tanks = ClientTanks.findAllByAccount(account)
        }

        if(booleanIndex > 0) {
            def tankIds = tanks.id.toString().replace("[","(").replace("]",")")
            tanks = ClientTanks.findAll("from ClientTanks Where ${trueFalseListNames[booleanIndex]}=true AND id IN " + tankIds)
        }

        if(inputFieldsIndex > 0) {
            def tankIds = tanks.id.toString().replace("[","(").replace("]",")")
            tanks = ClientTanks.findAll("from ClientTanks Where ${inputFieldsListNames[inputFieldsIndex]} LIKE '%${params.inputFieldText}%' AND id IN " + tankIds)
        }

        return tanks
    }
}
