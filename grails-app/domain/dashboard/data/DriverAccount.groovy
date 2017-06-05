package dashboard.data

class DriverAccount {

    Driver driver
    Date useDate = new Date()

    static hasMany = [accounts:Account]

    static constraints = {
        driver  nullable: false
        useDate nullable: false
    }
}
