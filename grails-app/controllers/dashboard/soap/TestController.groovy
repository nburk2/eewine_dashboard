package dashboard.soap

import com.bertramlabs.plugins.SSLRequired
import grails.plugin.springsecurity.annotation.Secured
import grails.util.Holders

@Secured(["ROLE_ADMIN"])
@SSLRequired
class TestController {

    def smartconnectService


    def index() {
        println "hello"
        def config = Holders.config
        def apiLoginId = config.APILOGINID
        println apiLoginId

        [output:apiLoginId]
    }

    def soap2() {
//        smartconnectService.getTransactions()
        smartconnectService.getDeliveryLocations()

    }

}
