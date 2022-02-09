package dashboard.data

import com.amazonaws.services.s3.model.GetObjectRequest
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
        tankJson
    }

    Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    def getTankJsonByDate(date) {
        date = addHoursToJavaUtilDate(date,6)

        def versions = amazonS3Service.client.listVersions("wine-energy","dashboard-backup/veederRootSites.json",null,null,null,1000)
        def versionSummaries = versions.getVersionSummaries()
        def lastVersion = versionSummaries[versionSummaries.size-1]

        while(date<lastVersion.lastModified) {
            String versionStartingPoint = lastVersion.versionId
            versions = amazonS3Service.client.listVersions("wine-energy","dashboard-backup/veederRootSites.json","dashboard-backup/veederRootSites.json",versionStartingPoint,null,1000)
            versionSummaries = versions.getVersionSummaries()
            if(versionSummaries.size()==0){
                return 0
            }
            lastVersion = versionSummaries[versionSummaries.size-1]
        }

        def version = findClosestVersion(versionSummaries,date)
        String versionId = version.versionId

        File localFile = new File("tank.json")
        amazonS3Service.client.getObject(new GetObjectRequest("wine-energy", "dashboard-backup/veederRootSites.json",versionId), localFile)

        def versionJson = new JsonSlurper().parseText(localFile.text)
//        Headers.GET_OBJECT_IF_MODIFIED_SINCE
        localFile.delete()
        versionJson
    }

    def findClosestVersion(versions,date) {
        def closestVersion
        def oldTimeDiff
        def latestTimeDiff = 1
//        closestVersion.lastModified.getTime() - date.getTime()
        def i = 0
        for(i;(i<versions.size() && latestTimeDiff>0);i++) {
            if(i>0) {
                oldTimeDiff = versions[i-1].lastModified.getTime() - date.getTime()
            }
            closestVersion = versions[i]

            latestTimeDiff = versions[i].lastModified.getTime() - date.getTime()
        }

        if((i+1)==versions.size()) {
            return closestVersion
        } else if(i==0) {
            return closestVersion
        }

        if(oldTimeDiff < (date.getTime() - versions[i].lastModified.getTime())) {
            return versions[i-1]
        }
        return closestVersion

    }

    def getTankInfoList() {
        def tankJson = getTankJson()
        tankJson
    }

    def getTankInfoListByDate(date) {
        def tankJson = getTankJsonByDate(date)
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
