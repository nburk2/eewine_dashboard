package dashboard.fuelaccounts

class Accounts {

    String name
    Integer number
    boolean discontinued
    static hasMany = [tanks:Tanks]

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



    static constraints = {

        name            nullable: false, maxSize: 255, unique: false
        number          nullable: false, unique: true
    }
}
