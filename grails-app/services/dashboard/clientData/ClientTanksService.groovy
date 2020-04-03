package dashboard.clientData

import grails.transaction.Transactional

@Transactional
class ClientTanksService {

    def tanks = []

    def uploadTanks(file) {
        file.inputStream.eachLine { line ->
            def lineSplit = line.split(',')
            tanks << lineSplit
        }
        createUpdateTanks()
    }

    def createUpdateTanks() {
//        static belongsTo = [account: ClientAccounts]
        tanks.each { tank ->
            if(tank[1] != "Benchmark Utility Services") {
                def account = ClientAccounts.findOrCreateByNumberAndName(tank[3].toInteger(), tank[2][1].trim())
                def newTank = ClientTanks.findOrCreateByNumberAndAccount(tank[4].trim().toInteger(), account)

                newTank.account = account
                //        int number
                newTank.number = tank[4].trim().toInteger()
                //        String address
                newTank.address = tank[5].trim()
                //        String location
                newTank.location = tank[7].trim()
                //        boolean wineEnergyOwned
                newTank.wineEnergyOwned = tank[11].trim().toLowerCase().contain("y") ? true : false
                //        boolean customerOwned
                newTank.customerOwned = tank[12].trim().toLowerCase().contain("y") ? true : false
                //        String serialNumber
                newTank.serialNumber = tank[13].trim()
                //        String manufacturer
                newTank.manufacturer = tank[14].trim()
                //        int size
                newTank.size = tank[15].trim().toInteger()
                //        String type
                newTank.type = tank[16].trim()
                //        String product
                newTank.product = tank[17].trim()
                //        boolean propertyLabeled
                newTank.propertyLabeled = tank[18].trim()
                //        boolean tertiaryContainment
                newTank.tertiaryContainment = tank[19].trim()
                //        boolean painted
                newTank.painted = tank[20].trim().toLowerCase().contain("y") ? true : false
                //        String color
                newTank.color = tank[21].trim()
                //        String paintCondition
                newTank.paintCondition = tank[22].trim()
                //        boolean wineEnergyLogo
                newTank.wineEnergyLogo = tank[23].trim().toLowerCase().contain("y") ? true : false
                //        String logoCondition
                newTank.logoCondition = tank[24].trim()
                //        String pumpType
                newTank.pumpType = tank[25].trim()
                //        int numberOfPumps
                newTank.numberOfPumps = tank[26].trim().toInteger()
                //        String pumpPartNumber
                newTank.pumpPartNumber = tank[27].trim()
                //        int numberOfDispensers
                newTank.numberOfDispensers = tank[28].trim().toInteger()
                //        String nozzleType
                newTank.nozzleType = tank[29].trim()
                //        String hoseGaugeLength
                newTank.hoseGaugeLength = tank[30].trim()
                //        boolean filter
                newTank.filter = tank[31].trim().toLowerCase().contain("y") ? true : false
                //        String filterType
                newTank.filterType = tank[32].trim()
                //        String filterPartNumber
                newTank.filterPartNumber = tank[33].trim()
                //        boolean ecogreen
                newTank.ecogreen = tank[34].trim().toLowerCase().contain("y") ? true : false
                //        String ecogreenSerialNumber
                newTank.ecogreenSerialNumber = tank[35].trim()
                //        boolean tankGauge
                newTank.tankGauge = tank[36].trim().toLowerCase().contain("y") ? true : false
                //        String comments
                newTank.comments = tank[39].trim()
                //        String completedBy
                newTank.completedBy = tank[48].trim()

                newTank.save()
            }
        }
    }

    def findTanks(params) {
        def tanks = []
        def trueFalseList = ["","Wine Energy Owned","Customer Owned", "Property Labeled","Tertiary Containment","Painted","Wine Energy Logo","Filter","Ecogreen","Tank Gauge"]
        def inputFieldsList = ["","Address","Serial Number","Manufacturer","Size","Type","Product","Color","Paint Condition","Number Of Pumps","Number Of Dispensers","Comments","Completed By"]
        def trueFalseListNames = ["","wineEnergyOwned","customerOwned", "propertyLabeled","tertiaryContainment","painted","wineEnergyLogo","filter","ecogreen","tankGauge"]
//        def inputFieldsList = ["address","serialNumber","manufacturer","size","type","product","color","paintCondition","numberOfPumps","numberOfDispensers","comments","completedBy"]
        if(!params.booleanField && !params.inputField && !params.account && !params.inputFieldText) {
            return tanks
        }

        def booleanIndex = trueFalseList.contains(params.booleanField)
        def inputFieldsIndex = inputFieldsList.contains(params.inputField)

        if(params.account) {
            def account = ClientAccounts.findById(params.account.toInteger())
            tanks = ClientTanks.findAllByAccount(account)
        }

        if(booleanIndex >= 0) {

        }

    }
}
