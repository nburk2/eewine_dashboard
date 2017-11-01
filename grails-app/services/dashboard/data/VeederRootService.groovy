package dashboard.data

import grails.util.Holders
import groovy.json.JsonSlurper
import grails.transaction.Transactional
import grails.plugins.rest.client.RestBuilder
import com.amazonaws.services.s3.model.CannedAccessControlList

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
        println tankJson
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

    def uploadFileToPrint(multipartFile) {
        amazonS3Service.defaultBucketName = "wine-energy"
        // Check if an object exists in bucket
        def found = amazonS3Service.exists('filesToPrint/' + multipartFile.getOriginalFilename())
        def additionalVal = 0
        while (found) {
            additionalVal++
            found = amazonS3Service.exists('filesToPrint/' + multipartFile.getOriginalFilename().replace(".","${additionalVal}."))
        }
        if(additionalVal == 0) {
            additionalVal = ""
        }
        amazonS3Service.storeMultipartFile('filesToPrint/' + multipartFile.getOriginalFilename().replace(".","${additionalVal}."), multipartFile, CannedAccessControlList.Private)
    }

    def getS3FilesToPrint() {
        def filesToPrint = amazonS3Service.listObjects('wine-energy', 'filesToPrint/')
        filesToPrint.objectSummaries.removeAll{
            it.key == "filesToPrint/"
        }
        filesToPrint.objectSummaries
    }
}
