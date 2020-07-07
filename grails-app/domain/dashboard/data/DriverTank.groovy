package dashboard.data

import dashboard.fuelaccounts.Tanks

class DriverTank {

    Driver driver
    Date scheduledDay = new Date().clearTime()

    static hasMany = [tanks:Tanks]

    static constraints = {
        driver  nullable: false
       scheduledDay nullable: false
    }
}