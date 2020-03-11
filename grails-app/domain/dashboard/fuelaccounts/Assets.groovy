package dashboard.fuelaccounts

class Assets {

    static belongsTo = [account: Accounts]
    int assetId
    String barcode

    int comdataCardNum
    String department

    static constraints = {
        account nullable: false
        assetId nullable: false, unique: true
        barcode nullable: false, unique: ['account']

        comdataCardNum blank:true
        department blank: true
    }
}
