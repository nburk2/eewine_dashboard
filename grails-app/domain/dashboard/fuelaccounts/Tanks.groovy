package dashboard.fuelaccounts

class Tanks {

//    Accounts account
    static belongsTo = [account: Accounts]
    int tankNum

    String poNumber = ""

    //mansfield & fuel All & mansfieldTank
    String customerNumber = ""
    String shipTo = ""
    String supplierCode = ""

    //comdata
    String cardNumber = "" //rename to siteId from world fuel or keep it as cardNumber

    //  World fuel
    String billTo = ""
    // World fuel and special export
    String siteId = ""



    static constraints = {
        account nullable: false
        tankNum nullable: false, unique: ['account']
        poNumber blank:true
        customerNumber blank: true
        shipTo blank: true
        supplierCode blank: true
        cardNumber blank: true
        billTo blank: true
        siteId blank: true
    }

}
