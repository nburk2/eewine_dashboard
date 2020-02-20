package dashboard.fuelaccounts

class Accounts {

    String name
    Integer number
    boolean discontinued
    boolean sendEmail
    boolean print
    static hasMany = [tanks:Tanks]

    //invoice groups
    boolean standard
    boolean mansfield
    boolean mansfieldTank
    boolean fuelAll
    boolean standardWeekly
    boolean standardBiWeekly
    boolean standardMonthly
    boolean reston
    boolean specialExport
    boolean phoenix
    boolean mclean
    boolean worldFuel
    boolean comdata
    boolean comdataMileage

//    reporting groups
    boolean weekly
    boolean biWeekly
    boolean monthly
    boolean quarterly

    boolean includePrice
    boolean sendReportEmail
    boolean printReport


    static constraints = {

        name            nullable: false, maxSize: 255, unique: false
        number          nullable: false, unique: true
    }

    static mapping = {
        sendEmail defaultValue: false
        print defaultValue: false

        includePrice defaultValue: false
        sendReportEmail defaultValue: false
        printReport defaultValue: false
        weekly defaultValue: false
        biWeekly defaultValue: false
        monthly defaultValue: false
        quarterly defaultValue: false
    }
}
