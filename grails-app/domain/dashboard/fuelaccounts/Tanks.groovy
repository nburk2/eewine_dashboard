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

    //for troy scheduling
    boolean monday
    boolean tuesday = false
    boolean wednesday = false
    boolean thursday = false
    boolean friday = false
    boolean saturday = false
    boolean sunday = false
    boolean show = false


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
        monday defaultValue: false
        tuesday defaultValue: false
        wednesday defaultValue: false
        thursday defaultValue: false
        friday defaultValue: false
        saturday defaultValue: false
        sunday defaultValue: false
        show defaultValue: false
    }

}
