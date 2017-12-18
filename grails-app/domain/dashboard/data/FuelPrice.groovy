package dashboard.data

class FuelPrice {

    String fuelType
    String description
    Integer bpc
    Float price
    Integer productId
    Date effectiveDate
    Date dateCreated


    static constraints = {
        fuelType(nullable: false, unique: ['bpc','productId','dateCreated'])
        description nullable: false, unique: false
        bpc nullable: false, unique: false
        price nullable: false, unique: false
        productId nullable: false, unique: false
        effectiveDate nullable: false, unique: false

    }
}
