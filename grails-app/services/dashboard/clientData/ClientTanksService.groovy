package dashboard.clientData

import grails.transaction.Transactional

@Transactional
class ClientTanksService {

    def tankFields = []

    def uploadTanks(file) {
        file.inputStream.eachLine { line ->
            def lineSplit = line.split(',')
            tankFields << lineSplit
        }
        createUpdateTanks()
    }

    def createUpdateTanks() {
//        static belongsTo = [account: ClientAccounts]
        def account = ClientAccounts.findOrCreateByNumberAndName(tankFields[3][1].toInteger(),tankFields[2][1].trim())
        def newTank = ClientTanks.findOrCreateByNumberAndAccount(tankFields[4][1].trim().toInteger(),account)

        newTank.account = account
//        int number
        newTank.number = tankFields[4][1].trim().toInteger()
//        String address
        newTank.address = tankFields[5][1].trim()
//        String location
        newTank.location = tankFields[7][1].trim()
//        boolean wineEnergyOwned
        newTank.wineEnergyOwned = tankFields[11][1].trim().toLowerCase().contain("y") ? true : false
//        boolean customerOwned
        newTank.customerOwned = tankFields[12][1].trim().toLowerCase().contain("y") ? true : false
//        String serialNumber
        newTank.serialNumber = tankFields[13][1].trim()
//        String manufacturer
        newTank.manufacturer = tankFields[14][1].trim()
//        int size
        newTank.size = tankFields[15][1].trim().toInteger()
//        String type
        newTank.type = tankFields[16][1].trim()
//        String product
        newTank.product = tankFields[17][1].trim()
//        boolean propertyLabeled
        newTank.propertyLabeled = tankFields[18][1].trim()
//        boolean tertiaryContainment
        newTank.tertiaryContainment = tankFields[19][1].trim()
//        boolean painted
        newTank.painted = tankFields[20][1].trim().toLowerCase().contain("y") ? true : false
//        String color
        newTank.color = tankFields[21][1].trim()
//        String paintCondition
        newTank.paintCondition = tankFields[22][1].trim()
//        boolean wineEnergyLogo
        newTank.wineEnergyLogo = tankFields[23][1].trim().toLowerCase().contain("y") ? true : false
//        String logoCondition
        newTank.logoCondition = tankFields[24][1].trim()
//        String pumpType
        newTank.pumpType = tankFields[25][1].trim()
//        int numberOfPumps
        newTank.numberOfPumps = tankFields[26][1].trim().toInteger()
//        String pumpPartNumber
        newTank.pumpPartNumber = tankFields[27][1].trim()
//        int numberOfDispensers
        newTank.numberOfDispensers = tankFields[28][1].trim().toInteger()
//        String nozzleType
        newTank.nozzleType = tankFields[29][1].trim()
//        String hoseGaugeLength
        newTank.hoseGaugeLength = tankFields[30][1].trim()
//        boolean filter
        newTank.filter = tankFields[31][1].trim().toLowerCase().contain("y") ? true : false
//        String filterType
        newTank.filterType = tankFields[32][1].trim()
//        String filterPartNumber
        newTank.filterPartNumber = tankFields[33][1].trim()
//        boolean ecogreen
        newTank.ecogreen = tankFields[34][1].trim().toLowerCase().contain("y") ? true : false
//        String ecogreenSerialNumber
        newTank.ecogreenSerialNumber = tankFields[35][1].trim()
//        boolean tankGauge
        newTank.tankGauge = tankFields[36][1].trim().toLowerCase().contain("y") ? true : false
//        String comments
        newTank.comments = tankFields[39][1].trim()
//        String completedBy
        newTank.completedBy = tankFields[48][1].trim()

        newTank.save()
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
