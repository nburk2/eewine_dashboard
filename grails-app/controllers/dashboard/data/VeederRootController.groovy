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
        def tankInfoList = veederRootService.getTankInfoList()
        render view: "ninetyPercentages", model:[tankInfoList: tankInfoList]
    }

    def updateVeederRootData() {
        veederRootService.updateVeederRootData()
        def tankInfoList = veederRootService.getTankInfoList()
        render view: "ninetyPercentages", model:[tankInfoList: tankInfoList]
    }

    def uploadFileToPrint() {

        render view: "uploadFileToPrint", model: []
    }

    def uploadFile() {
        def errors = []
        def success

        MultipartFile multipart = request.getFile('fileToPrint')


        if(!multipart) {
            render view: "uploadFileToPrint"
            return
        }

        try {
            veederRootService.uploadFileToPrint(multipart)
        } catch (e) {
            render view: "uploadFileToPrint", model: [errors:true]
            return
        }

        render view: "uploadFileToPrint", model: [success:true]
    }
}
