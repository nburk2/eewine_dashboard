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

    def createFuelPriceExcel() {
        def fuelPrices = getFuelPrices()

        File file = new File('fuelPrices.xlsx')

        ExcelBuilder.output(new FileOutputStream(file)) {
            sheet([width:20]) {
                fuelPrices.each { fuelPrice ->
                    row(fuelPrice.name)
                    fuelPrice.rows.each { tempRow ->
                        row(tempRow.bpc, tempRow.description,tempRow.price,tempRow.effectiveDate)
                    }
                    row()
                }
            }
        }
    }

    def createDtnPriceExcel() {
        def dtnPrices = getDtnPrices()
        File file = new File('dtnPrices.xlsx')

        ExcelBuilder.output(new FileOutputStream(file)) {
            sheet([width:12]) {
                row("DTN Prices")
                row("Description", "Conoco Cont.", "Conoco", "Sunoco", "BP", "Hug", "TPSI")
                dtnPrices.each { dtnPrice ->
                    def conocoContract = ""
                    def conoco = ""
                    def sunoco = ""
                    def bp = ""
                    def hug = ""
                    def tpsi = ""
                    dtnPrice.supplier.each { tempRow ->
                        switch(tempRow.name) {
                            case "Conoco Contract":conocoContract = tempRow.price
                                break
                            case "Conoco":conoco = tempRow.price
                                break
                            case "Sunoco":sunoco = tempRow.price
                                break
                            case "BP":bp = tempRow.price
                                break
                            case "Huguenot":hug = tempRow.price
                                break
                            case "TPSI":tpsi = tempRow.price
                                break
                        }
                    }
                    row(dtnPrice.product + " ${dtnPrice.description}",conocoContract,conoco,sunoco,bp,hug,tpsi)
                }
            }
        }
    }

    def uploadS3FileToPrint(File file) {
        amazonS3Service.defaultBucketName = "wine-energy"
        amazonS3Service.storeFile('filesToPrint/' + file.name, file, CannedAccessControlList.Private)
    }

    def getFuelPrices() {
        String fuelPriceSignedUrl = getFuelPriceFileUrl("documents/FuelPrices.csv")
        InputStream input = new URL(fuelPriceSignedUrl).openStream()
        Reader reader = new InputStreamReader(input, "UTF-8")

        def fuelPriceMap = csvToMap(reader)

        def fuelPrices = mapFuelPrices(fuelPriceMap, priceMapping())
        fuelPrices
    }

    def getDtnPrices() {
        String fuelPriceSignedUrl = getFuelPriceFileUrl("documents/DtnPrices.json")
        InputStream input = new URL(fuelPriceSignedUrl).openStream()
        Reader reader = new InputStreamReader(input, "UTF-8")
        def jsonSlurper = new JsonSlurper()
        def dtnObject = jsonSlurper.parseText(reader.text)
        dtnObject
    }

    def mapFuelPrices(fuelPriceMap, priceMapping) {
        def fuelPrices = []
        priceMapping.each { category ->
            def rows = []
            category.BPCList.each { bpc ->
                def priceInfo = getPriceInfo(category.prod, bpc, fuelPriceMap)
                if(priceInfo) {
                    rows << [
                            bpc:priceInfo["Base Price Code"],
                            description:priceInfo.description,
                            price:priceInfo["Price Per Unit"],
                            effectiveDate:priceInfo["Effective Date"]
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

    def priceMapping() {
        return  [
                    [
                            name:"On Road",
                            prod:"3",
                            BPCList:["14","7","13","12","11","15"]
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
                            BPCList:["13","12","11","15"]
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
}
