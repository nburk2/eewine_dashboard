package dashboard.data

import grails.plugin.springsecurity.annotation.Secured
import com.bertramlabs.plugins.SSLRequired

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
}
