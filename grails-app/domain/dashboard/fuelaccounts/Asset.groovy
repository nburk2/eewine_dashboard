package dashboard.fuelaccounts

class Asset {

    static belongsTo = [account: Accounts]
    int assetId
    String barcode
    int tankNum
    String description

    Long comdataCardNum
    String department

    static constraints = {
        account nullable: false
        tankNum nullable: false
        assetId nullable: false, unique: true
        barcode nullable: false, unique: ['account']
        description nullable: true, blank: true

        comdataCardNum nullable: true
        department nullable: true
    }
}
