package dashboard.data

import grails.util.Holders
import groovy.json.JsonSlurper
import grails.transaction.Transactional
import grails.plugins.rest.client.RestBuilder

@Transactional
class VeederRootService {

    def config = Holders.config
    def gatewayKey = config.GATEWAY_KEY
    def amazonS3Service
    def rest = new RestBuilder()

    def serviceMethod() {

    }

    def getTankJson() {
        amazonS3Service.defaultBucketName = "wine-energy"
        def file = amazonS3Service.getFile('dashboard-backup/veederRootSites.json', 'tank.json')
        def tankJson = new JsonSlurper().parseText(file.text)
        file.delete()
        tankJson
    }

    def getTankInfoList() {
        def tankJson = getTankJson()
        tankJson
    }

    def updateVeederRootData() {
        def resp = rest.get("https://ibkxdho8ce.execute-api.us-east-1.amazonaws.com/prod/veeder-root-update") {
            headers["x-api-key"] = gatewayKey
        }
        resp
    }
}
