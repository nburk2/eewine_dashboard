package dashboard.data

import grails.transaction.Transactional
import grails.util.Holders
import grails.plugins.rest.client.RestBuilder
import groovy.json.*
import com.jameskleeh.excel.ExcelBuilder
import org.grails.web.json.JSONObject
import com.amazonaws.services.s3.model.CannedAccessControlList

@Transactional
class FuelPriceService {

    def config = Holders.config
    def gatewayKey = config.GATEWAY_KEY
    def amazonS3Service
    def rest = new RestBuilder()

    def getFuelPriceFileUrl(key) {
        def resp = rest.get("https://ibkxdho8ce.execute-api.us-east-1.amazonaws.com/prod/gets3file?bucket=wine-energy&key=" + key) {
            headers["x-api-key"] = gatewayKey
        }
        return resp.json.signedUrl
    }

    def createFuelPriceExcel(date) {
        def fuelPrices
        if(date) {
            fuelPrices = getFuelPricesByDate(date)
        } else {
            fuelPrices = getFuelPrices()
        }

        File file = new File('fuelPrices.xlsx')

        ExcelBuilder.output(new FileOutputStream(file)) {
            sheet([width:20]) {
                fuelPrices.each { fuelPrice ->
                    row(fuelPrice.name)
                    fuelPrice.rows.each { tempRow ->
                        row(tempRow.bpc, tempRow.description,"${tempRow.price.toBigDecimal()}",tempRow.effectiveDate)
                    }
                    row()
                }
            }
        }
    }

    def createDtnPriceExcel(date) {
        def dtnPrices
        if(date) {
            dtnPrices = getDtnPricesByDate(date)
        } else {
            date = new Date()
            dtnPrices = getDtnPrices()
        }
        File file = new File('dtnPrices.xlsx')
        def conocoContract = ""
        def conoco = ""
        def sunoco = ""
        def bp = ""
        def hug = ""
        def tpsi = ""

        ExcelBuilder.output(new FileOutputStream(file)) {
            sheet([width:12]) {
                row("DTN Prices", date)
                row("Description", "Conoco Cont.", "Conoco", "Sunoco")
                dtnPrices.each { dtnPrice ->
                    dtnPrice.supplier.each { tempRow ->
                        switch(tempRow.name) {
                            case "Conoco Contract":conocoContract = "${tempRow.price.toBigDecimal()}"
                                break
                            case "Conoco":conoco = "${tempRow.price.toBigDecimal()}"
                                break
                            case "Sunoco":sunoco = "${tempRow.price.toBigDecimal()}"
                                break
                        }
                    }
                    row(dtnPrice.product + " ${dtnPrice.description}",conocoContract,conoco,sunoco)
                }
                row()
                row()
                row("Description", "BP", "Hug", "TPSI")
                dtnPrices.each { dtnPrice ->
                    dtnPrice.supplier.each { tempRow ->
                        switch(tempRow.name) {
                            case "BP":bp = "${tempRow.price.toBigDecimal()}"
                                break
                            case "Huguenot":hug = "${tempRow.price.toBigDecimal()}"
                                break
                            case "TPSI":tpsi = "${tempRow.price.toBigDecimal()}"
                                break
                        }
                    }
                    row(dtnPrice.product + " ${dtnPrice.description}",bp,hug,tpsi)
                }
            }
        }
    }

    def uploadS3FileToPrint(File file) {
        amazonS3Service.defaultBucketName = "wine-energy"
        amazonS3Service.storeFile('filesToPrint/' + file.name, file, CannedAccessControlList.Private)
    }

    def addTodaysFuelPrices() {
        def fuelPrices = getFuelPrices()
        def todaysDate = new Date()
        todaysDate.clearTime()
        fuelPrices.each { fuelType ->
            fuelType.rows.each { price ->
                def fuelPrice = new FuelPrice()
                fuelPrice.fuelType = fuelType.name
                fuelPrice.description = price.description
                fuelPrice.bpc = price.bpc.toInteger()
                fuelPrice.price = price.price.toFloat()
                fuelPrice.productId = price.productId.toInteger()
                fuelPrice.effectiveDate = new Date(price.effectiveDate)
                fuelPrice.createdDate = todaysDate
                fuelPrice.save()
            }
        }
    }

    def addTodaysDtnPrices() {
        def dtnPrices = getDtnPrices()
        def todaysDate = new Date()
        todaysDate.clearTime()
        dtnPrices.each { dtnPrice ->
            dtnPrice.supplier.each { supplier ->
                def dtn =  new DtnPrice()
                dtn.supplier = supplier.name
                dtn.description = dtnPrice.description
                dtn.price = supplier.price.toFloat()
                dtn.productId = dtnPrice.product
                dtn.effectiveDate = todaysDate
                dtn.createdDate = todaysDate
                dtn.save()
            }
        }
    }

    def getDtnPricesByDate(priceDate) {
        def dtnMapping = dtnMapping()
        def dtnPrices = []
        dtnMapping.each { dtnProduct ->
            def dtnInfo
            def newSuppliers = []
            dtnProduct.suppliers.each { supplier ->
                dtnInfo = DtnPrice.findBySupplierAndProductIdAndEffectiveDate(supplier,dtnProduct.productId,priceDate)
                def oldDtnPrice = DtnPrice.findBySupplierAndProductIdAndEffectiveDate(supplier,dtnProduct.productId,priceDate - 1)
//                newSuppliers << [name:supplier, price:dtnInfo?.price, difference: (dtnInfo?.price?.toBigDecimal() ?: 0 - (oldDtnPrice?.price?.toBigDecimal() ?: (dtnInfo?.price?.toBigDecimal()) ?: 0))?.toString()]
                newSuppliers << [name:supplier, price:dtnInfo?.price ?: 0, difference: ((dtnInfo?.price?.toBigDecimal() ?: 0) - (oldDtnPrice?.price?.toBigDecimal() ?: dtnInfo?.price?.toBigDecimal() ?: 0)).toString()]
            }
            dtnPrices << [product:dtnProduct.productId, description: dtnInfo?.description ?: "", supplier:newSuppliers]
        }
//        dtnPrices = addDTNPriceHike(dtnPrices)
        dtnPrices
    }

    def getFuelPricesByDate(priceDate) {
        def fuelMapping = fuelMapping()
        def fuelPrices = []
        fuelMapping.each { category ->
            def rows = []
            category.BPCList.each { bpc ->
                def priceInfo = FuelPrice.findByProductIdAndBpcAndCreatedDate(category.prod, bpc, priceDate)
                if(priceInfo) {
                    def oldFuelPrice = FuelPrice.findByFuelTypeAndBpcAndProductIdAndCreatedDate(category.name,priceInfo.bpc,category.prod,(priceDate - 1).clearTime())
                    rows << [
                            bpc:priceInfo.bpc,
                            description:priceInfo.description,
                            price:priceInfo.price,
                            effectiveDate:priceInfo.effectiveDate.format("MM/dd/YYYY"),
                            productId:priceInfo.productId,
                            difference: priceInfo.price.toBigDecimal() - (oldFuelPrice?.price?.toBigDecimal() ?: priceInfo.price.toBigDecimal())
                    ]
                }
            }
            fuelPrices << [
                    name: category.name,
                    rows: rows
            ]

        }
        fuelPrices
    }

    def getFuelPrices() {
        String fuelPriceSignedUrl = getFuelPriceFileUrl("documents/FuelPrices.csv")
        InputStream input = new URL(fuelPriceSignedUrl).openStream()
        Reader reader = new InputStreamReader(input, "UTF-8")

        def fuelPriceMap = csvToMap(reader)

        def fuelPrices = mapFuelPrices(fuelPriceMap, fuelMapping())
        fuelPrices
    }

    def getDtnPrices() {
        String fuelPriceSignedUrl = getFuelPriceFileUrl("documents/DtnPrices.json")
        InputStream input = new URL(fuelPriceSignedUrl).openStream()
        Reader reader = new InputStreamReader(input, "UTF-8")
        def jsonSlurper = new JsonSlurper()
        def dtnObject = jsonSlurper.parseText(reader.text)
        dtnObject = addDTNPriceHike(dtnObject)
        dtnObject
    }

    def addDTNPriceHike(dtnObject) {
        for(def index=0;index<dtnObject.size;index++) {
            for(def supIndex=0;supIndex<dtnObject[index].supplier.size;supIndex++) {
                if(dtnObject[index].supplier[supIndex].name=="MARATHON" && dtnObject[index].supplier[supIndex].price.toFloat() > 0) {
                    dtnObject[index].supplier[supIndex].price = (dtnObject[index].supplier[supIndex].price.toFloat() - 0.005).round(6)
                }//3.741507 to 3.736557 ---- 3.077019 to 3.072069   ----  3.217005 to 3.212055  ------ 3.496977 to 3.492027 ----- 2.960496 to 2.955546
                if(dtnObject[index].supplier[supIndex].name=="Sunoco" || dtnObject[index].supplier[supIndex].name=="BP" || dtnObject[index].supplier[supIndex].name=="MARATHON") {
                    dtnObject[index].supplier[supIndex].price = (dtnObject[index].supplier[supIndex].price.toFloat() * 0.99).round(6)
                    dtnObject[index].supplier[supIndex].price = dtnObject[index].supplier[supIndex].price.toString()
                }
            }

        }
        return dtnObject
    }

    def mapFuelPrices(fuelPriceMap, fuelMapping) {
        def fuelPrices = []
        fuelMapping.each { category ->
            def rows = []
            category.BPCList.each { bpc ->
                def priceInfo = getPriceInfo(category.prod, bpc, fuelPriceMap)
                if(priceInfo) {
                    def oldFuelPrice = FuelPrice.findByFuelTypeAndBpcAndProductIdAndCreatedDate(category.name, priceInfo["Base Price Code"], category.prod, (new Date() - 1).clearTime())
                    if (priceInfo["Price Per Unit"].isNumber()) {
                        rows << [
                                bpc          : priceInfo["Base Price Code"],
                                description  : priceInfo.description,
                                price        : priceInfo["Price Per Unit"],
                                effectiveDate: priceInfo["Effective Date"],
                                productId    : category.prod,
                                difference   : priceInfo["Price Per Unit"].toBigDecimal() - (oldFuelPrice?.price?.toBigDecimal() ?: priceInfo["Price Per Unit"].toBigDecimal())
                        ]
                }
                }
            }
            fuelPrices << [
                    name: category.name,
                    rows: rows
            ]

        }
        fuelPrices
    }

    def getPriceInfo(productId, bpc, fuelPriceMap) {
        def priceInfoChunk = null
        fuelPriceMap.each { priceInfo ->
            if(priceInfo.Product == productId && priceInfo["Base Price Code"] == bpc) {
                priceInfoChunk = priceInfo
            }
        }
        priceInfoChunk
    }

    def csvToMap(reader) {
        def rows = []
        def lines = reader.readLines()
        def keys = lines[0].split(',')
        lines[1..-1].collect { line ->
            def i = 0, vals = line.split(',')
            JSONObject row = new JSONObject()
            vals.each { val ->
                row.put(keys[i], val)
                i++
            }
            rows << row
        }
        rows
    }

    def fuelMapping() {
        return  [
                    [
                            name:"On Road",
                            prod:"3",
                            BPCList:["14","7","8","13","12","11","15"]
                    ],
                    [
                            name:"Off Road",
                            prod:"5",
                            BPCList:["14","13","12","11","15"]
                    ],
                    [
                            name:"Heating Oil",
                            prod:"2",
                            BPCList:["13","12","11"]
                    ],
                    [
                            name:"RFG Reg",
                            prod:"7",
                            BPCList:["14","13","12","11","15"]
                    ],
                    [
                            name:"RFG Mid",
                            prod:"8",
                            BPCList:["13","12","11","15"]
                    ],
                    [
                            name:"RFG Premium",
                            prod:"9",
                            BPCList:["13","12","11","15"]
                    ],
                    [
                            name:"Conv Reg",
                            prod:"17",
                            BPCList:["13","12","11","15"]
                    ],
                    [
                            name:"Conv Mid",
                            prod:"18",
                            BPCList:["13","12","11","15"]
                    ],
                    [
                            name:"Conv Prem",
                            prod:"19",
                            BPCList:["13","12","11","15"]
                    ]
                ]
    }

    def dtnMapping() {
//        ["Conoco Contract","Conoco", "Sunoco", "BP", "Huguenot", "BUCKEYE", "MARATHON", "United", "Sunoco Unbranded"]
        def suppliers = ["Conoco Contract","Conoco", "Sunoco", "BP", "Huguenot", "MARA UNB", "MARATHON", "United", "Sunoco Unbranded"]
        return [
                [
                        productId: 2,
                        suppliers: suppliers
                ],
                [
                        productId: 3,
                        suppliers: suppliers
                ],
                [
                        productId: 5,
                        suppliers: suppliers
                ],
                [
                        productId: 7,
                        suppliers: suppliers
                ],
                [
                        productId: 8,
                        suppliers: suppliers
                ],
                [
                        productId: 9,
                        suppliers: suppliers
                ],
                [
                        productId: 17,
                        suppliers: suppliers
                ],
                [
                        productId: 18,
                        suppliers: suppliers
                ],
                [
                        productId: 19,
                        suppliers: suppliers
                ]
        ]
    }
}
