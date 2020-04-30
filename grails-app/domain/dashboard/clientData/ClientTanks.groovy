package dashboard.clientData

class ClientTanks {

    static belongsTo = [account: ClientAccounts]
//    String number

//    Date creationDate
    String address
    String location
    String tankOwnership
    String serialNumber
    String manufacturer
    int size
    String type
    String product
    boolean properlyLabeled
    boolean tertiaryContainment
    boolean painted
    String color
    String paintCondition
    boolean wineEnergyLogo
    String logoCondition
    String pumpType
    String pumpCondition
    String pumpPartNumber
    int numberOfDispensers
    String nozzleType
    String hoseGaugeLength
    String filterType
    String filterPartNumber
    String filterCondition
    boolean ecogreen
    String ecogreenSerialNumber
    boolean tankGauge
    String comments
    String imageUrl

    static constraints = {
        account nullable: false
//        number nullable: true

        address nullable: true, blank:true
        location nullable: true, blank:true
//        creationDate nullable: true, blank:true
        tankOwnership nullable: true, blank:true
        serialNumber nullable: true, blank:true
        manufacturer nullable: true, blank:true
        size nullable: true, blank:true
        type nullable: true, blank:true
        product nullable: true, blank:true
        properlyLabeled nullable: true, blank:true
        tertiaryContainment nullable: true, blank:true
        painted nullable: true, blank:true
        color nullable: true, blank:true
        paintCondition nullable: true, blank:true
        wineEnergyLogo nullable: true, blank:true
        logoCondition nullable: true, blank:true
        pumpType nullable: true, blank:true
        pumpCondition nullable: true, blank:true
        pumpPartNumber nullable: true, blank:true
        numberOfDispensers nullable: true, blank:true
        nozzleType nullable: true, blank:true
        hoseGaugeLength nullable: true, blank:true
        filterType nullable: true, blank:true
        filterPartNumber nullable: true, blank:true
        filterCondition nullable: true, blank:true
        ecogreen nullable: true, blank:true
        ecogreenSerialNumber nullable: true, blank:true
        tankGauge nullable: true, blank:true
        comments nullable: true, blank:true
        imageUrl nullable: true, blank:true, maxSize:65535
    }
}
