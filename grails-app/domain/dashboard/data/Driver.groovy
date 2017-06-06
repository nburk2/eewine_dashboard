package dashboard.data

class Driver {
    String firstName
    String lastName
    Date medCardExpDate
    Date driversLicenseExpDate
    Date hazmatExpDate

    static constraints = {
        firstName               nullable: false, maxSize: 255
        lastName                nullable: false, maxSize: 255
        medCardExpDate          nullable: true
        driversLicenseExpDate   nullable: true
        hazmatExpDate           nullable: true
    }

    String toString() { firstName + " " + lastName }
}
