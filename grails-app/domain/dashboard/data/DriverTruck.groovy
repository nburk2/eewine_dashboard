package dashboard.data

class DriverTruck {
    Driver driver
    Truck truck
    Date useDate = new Date()
    boolean off = false

    static constraints = {
        driver  nullable: false
        truck   nullable: true
        useDate nullable: false
        off()
    }
}
