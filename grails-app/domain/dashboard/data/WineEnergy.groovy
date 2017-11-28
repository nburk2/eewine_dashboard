package dashboard.data

class WineEnergy {

    String name
    String value
    String description
    Date lastUpdated

    static constraints = {
        name nullable: false, unique: true, matches: "^[a-zA-Z-]*"
        value nullable: false
        description nullable: true
        lastUpdated nullable: true
    }
}
