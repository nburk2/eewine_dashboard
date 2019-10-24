package dashboard.fuelaccounts

class Tanks {

//    Accounts account
    static belongsTo = [account: Accounts]
    int tankNum

    String poNumber

    //mansfield & fuel All
    String customerNumber = ""
    String shipTo = ""
    String supplierCode = ""

    //special export & comdata
    String cardNumber = "" //rename to siteId from world fuel or keep it as cardNumber

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
