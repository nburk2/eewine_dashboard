package dashboard.data

class Truck {

    Integer number
    Integer modelYear
    Date stateInspectionExpDate
    Date tankVKExpDate
    Date tankIPExpDate

    static constraints = {
        number                  nullable: false, unique: true
        modelYear               nullable: false
        stateInspectionExpDate  nullable: false
        tankVKExpDate           nullable: true
        tankIPExpDate           nullable: true
    }
}
