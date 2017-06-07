package dashboard.data

class DriverAccount {

    Driver driver

    static hasMany = [accounts:Account]

    static constraints = {
        driver  nullable: false
    }
}
