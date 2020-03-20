package dashboard.clientData

class ClientAccounts {

    static hasMany = [tanks:ClientTanks]

    String name
    int number

    static constraints = {
        name            nullable: false, maxSize: 255, unique: false
        number          nullable: false, unique: true
    }
}
