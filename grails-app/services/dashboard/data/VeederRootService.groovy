package dashboard.data

import groovy.json.JsonSlurper
import grails.transaction.Transactional

@Transactional
class VeederRootService {

    def amazonS3Service

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
}
