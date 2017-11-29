package dashboard.data

import grails.transaction.Transactional
import grails.util.Holders
import grails.plugins.rest.client.RestBuilder

@Transactional
class WineEnergyService {

    def config = Holders.config
    def gatewayKey = config.GATEWAY_KEY
    def rest = new RestBuilder()

    def getWineEnergyDocuments() {
        def fileList = []
        def keys = ["documents/FuelPrices.csv"]
        keys.each { key ->
            def resp = rest.get("https://ibkxdho8ce.execute-api.us-east-1.amazonaws.com/prod/gets3file?bucket=wine-energy&key=" + key) {
                headers["x-api-key"] = gatewayKey
            }
            def name = key.split("/")
            name = name[name.size() - 1]
            fileList << [name:name,signedUrl:resp.json.signedUrl]
        }
        fileList
    }
}
