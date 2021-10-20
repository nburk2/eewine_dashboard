package dashboard.data

import grails.plugin.springsecurity.annotation.Secured
import com.bertramlabs.plugins.SSLRequired
import org.springframework.web.multipart.MultipartFile

@Secured(["ROLE_ADMIN", "ROLE_DRIVER"])
@SSLRequired
class VeederRootController {

    def veederRootService

    def index() {

    }

    def tankInfo() {
        def tankInfoList = veederRootService.getTankInfoList()
        render view: "tankInfo", model:[tankInfoList: tankInfoList]
    }

    def ninetyPercentages() {
        try{
            def tankInfoList
            Date priceDate
            println(params.values())
            if(params.priceDate) {
                priceDate = params.getDate("priceDate")
                tankInfoList = veederRootService.getTankInfoListByDate(priceDate)
                if(tankInfoList==0) {
                    tankInfoList = veederRootService.getTankInfoList()
                    render view: "ninetyPercentages", model:[error:"No Tank Data for this Date",tankInfoList: tankInfoList]
                    return
                }
            } else {
                tankInfoList = veederRootService.getTankInfoList()
            }
            render view: "ninetyPercentages", model:[tankInfoList: tankInfoList,priceDate:params.priceDate]
        } catch (e) {
            render view: "ninetyPercentages", model:[error:e,tankInfoList: []]
        }

    }

    def updateVeederRootData() {
        try{
            veederRootService.updateVeederRootData()
            def tankInfoList = veederRootService.getTankInfoList()
            render view: "ninetyPercentages", model:[tankInfoList: tankInfoList]
        } catch (e) {
            render view: "ninetyPercentages", model:[error:e,tankInfoList: []]
        }

    }

    def uploadFileToPrint() {

        def currentFilesToPrint = veederRootService.getS3FilesToPrint()

        render view: "uploadFileToPrint", model: [currentFilesToPrint: currentFilesToPrint]
    }

    def uploadFile() {
        def errors = []
        def success

        MultipartFile multipart = request.getFile('fileToPrint')
        def currentFilesToPrint = veederRootService.getS3FilesToPrint()


        if(!multipart) {
            render view: "uploadFileToPrint", model: [currentFilesToPrint: currentFilesToPrint]
            return
        }

        try {
            veederRootService.uploadFileToPrint(multipart)
            currentFilesToPrint = veederRootService.getS3FilesToPrint()
        } catch (e) {
            render view: "uploadFileToPrint", model: [errors:true,currentFilesToPrint: currentFilesToPrint]
            return
        }

        render view: "uploadFileToPrint", model: [success:true,currentFilesToPrint: currentFilesToPrint]
    }
}
