package dashboard.data

class DtnPrice {

    String supplier
    String description
    Float price
    Integer productId
    Date effectiveDate
    Date dateCreated


    static constraints = {
        supplier(nullable: false, unique: ['productId','effectiveDate'])
        description nullable: false, unique: false
        price nullable: false, unique: false
        productId nullable: false, unique: false
        effectiveDate nullable: false, unique: false
    }
}
