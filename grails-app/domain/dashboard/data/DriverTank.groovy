package dashboard.data

import dashboard.fuelaccounts.Tanks

class DriverTank {

    Driver driver
    Date scheduledDay = new Date().clearTime()
    String startTime
    String loadTime

    static hasMany = [tanks:Tanks]

    static constraints = {
        driver  nullable: false
        scheduledDay nullable: false
        startTime nullable: true
        loadTime nullable: true
    }
}