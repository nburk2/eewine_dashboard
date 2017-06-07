package dashboard.data

class DriverTruck {
    Driver driver
    Truck truck
    boolean off = false

    static constraints = {
        driver  nullable: false
        truck   nullable: true
        off()
    }
}
