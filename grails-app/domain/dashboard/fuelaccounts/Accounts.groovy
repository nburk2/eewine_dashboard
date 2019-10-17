package dashboard.fuelaccounts

class Accounts {

    String name
    Integer number
    boolean terminated = false
    static hasMany = [tanks:Tanks]

    boolean standard = false
    boolean mansfield = false
    boolean mansfieldTank = false
    boolean fuelAll = false
    boolean standardWeekly = false
    boolean standardBiWeekly = false
    boolean standardMonthly = false
    boolean reston = false
    boolean specialExport = false
    boolean phoenix = false
    boolean mclean = false
    boolean worldFuel = false
    boolean comdata = false
    boolean comdataMileage = false



    static constraints = {

        name            nullable: false, maxSize: 255, unique: false
        number          nullable: false, unique: true
        terminated()

        standard()
        mansfield()
    }
}
