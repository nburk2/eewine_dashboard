package dashboard.data

class Account {

    String name
    Integer numberOfTickets = 1
    boolean keyRequired = false //Key, open, combo

    static constraints = {
        name            nullable: false, maxSize: 255, unique: true
        numberOfTickets nullable: false
        keyRequired()
    }

    String toString() { name }
}
