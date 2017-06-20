package dashboard.data


class Driver {
    String firstName
    String lastName
    ColorType colorType
    Date medCardExpDate
    Date driversLicenseExpDate
    Date hazmatExpDate

    enum ColorType {
        BLUE("blue"),
        GREY("grey"),
        RED("red"),
        YELLOW("yellow"),
        GOLD("gold"),
        GREEN("green"),
        LIGHTBLUE("lightblue"),
        DARKBLUE("darkblue"),
        ROSYBROWN("sandybrown"),
        MEDIUMVIOLETRED("mediumvioletred")

        String prettyName

        ColorType(String prettyName){
            this.prettyName = prettyName
        }
    }

    static constraints = {
        firstName               nullable: false, maxSize: 255
        lastName                nullable: false, maxSize: 255
        colorType               nullable: true
        medCardExpDate          nullable: true
        driversLicenseExpDate   nullable: true
        hazmatExpDate           nullable: true
    }

    String toString() { firstName + " " + lastName }
}
