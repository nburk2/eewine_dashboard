package dashboard.data

class WineEnergy {

    String name
    String value

    static constraints = {
        name nullable: false, unique: true, matches: "^[a-zA-Z-]*"
        value nullable: false
    }
}
