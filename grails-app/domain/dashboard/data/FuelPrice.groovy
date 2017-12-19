package dashboard.data

class FuelPrice {

    String fuelType
    String description
    Integer bpc
    Float price
    Integer productId
    Date effectiveDate
    Date createdDate


    static constraints = {
        fuelType(nullable: false, unique: ['bpc','productId','createdDate'])
        description nullable: false, unique: false
        bpc nullable: false, unique: false
        price nullable: false, unique: false
        productId nullable: false, unique: false
        effectiveDate nullable: false, unique: false
        createdDate nullable: false, unique: false
    }
}
