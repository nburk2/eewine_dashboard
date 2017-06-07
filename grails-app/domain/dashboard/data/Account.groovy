package dashboard.data

class Account {

    String name
    Integer numberOfTickets = 1

    static constraints = {
        name            nullable: false, maxSize: 255, unique: true
        numberOfTickets nullable: false
    }

    String toString() { name }
}
