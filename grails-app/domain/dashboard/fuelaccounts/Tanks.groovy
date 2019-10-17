package dashboard.fuelaccounts

class Tanks {

//    Accounts account
    static belongsTo = [account: Accounts]
    int tankNum
    //All
//    String poNumber // change to cardNumber, only comdata uses

    //mansfield
    String customerNumber = ""
    String shipTo = ""
    String supplierCode = ""

    //special export
    String cardNumber = "" //rename to siteId

    //  World fuel
    String billTo = ""
    String siteId = ""



    static constraints = {
        account nullable: false
        tankNum nullable: false, unique: ['account']
        customerNumber blank: true
        shipTo blank: true
        supplierCode blank: true
        cardNumber blank: true
        billTo blank: true
        siteId blank: true
    }

}
