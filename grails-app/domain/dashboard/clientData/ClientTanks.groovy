package dashboard.clientData

class ClientTanks {

    static belongsTo = [account: ClientAccounts]
    int number

    String address
    String location
    boolean wineEnergyOwned
    boolean customerOwned
    String serialNumber
    String manufacturer
    int size
    String type
    String product
    boolean propertyLabeled
    boolean tertiaryContainment
    boolean painted
    String color
    String paintCondition
    boolean wineEnergyLogo
    String logoCondition
    String pumpType
    int numberOfPumps
    String pumpPartNumber
    int numberOfDispensers
    String nozzleType
    String hoseGaugeLength
    boolean filter
    String filterType
    String filterPartNumber
    boolean ecogreen
    String ecogreenSerialNumber
    boolean tankGauge
    String comments
    String completedBy

    static constraints = {
        account nullable: false
        number nullable: false, unique: ['account']

        address nullable: true, blank:true
        location nullable: true, blank:true
        wineEnergyOwned nullable: true, blank:true
        customerOwned nullable: true, blank:true
        serialNumber nullable: true, blank:true
        manufacturer nullable: true, blank:true
        size nullable: true, blank:true
        type nullable: true, blank:true
        product nullable: true, blank:true
        propertyLabeled nullable: true, blank:true
        tertiaryContainment nullable: true, blank:true
        painted nullable: true, blank:true
        color nullable: true, blank:true
        paintCondition nullable: true, blank:true
        wineEnergyLogo nullable: true, blank:true
        logoCondition nullable: true, blank:true
        pumpType nullable: true, blank:true
        numberOfPumps nullable: true, blank:true
        pumpPartNumber nullable: true, blank:true
        numberOfDispensers nullable: true, blank:true
        nozzleType nullable: true, blank:true
        hoseGaugeLength nullable: true, blank:true
        filter nullable: true, blank:true
        filterType nullable: true, blank:true
        filterPartNumber nullable: true, blank:true
        ecogreen nullable: true, blank:true
        ecogreenSerialNumber nullable: true, blank:true
        tankGauge nullable: true, blank:true
        comments nullable: true, blank:true
        completedBy nullable: true, blank:true
    }
}
