package dashboard.rest

import com.bertramlabs.plugins.SSLRequired
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Secured(["permitAll"])
@SSLRequired
@Transactional(readOnly = true)
class PaymentsController {

    def paymentsService

//    static allowedMethods = [sendAuthorizePayment: "GET"]
//    static allowedMethods = [sendAuthorizePayment: "POST"]

    def sendAuthorizePayment() {
        if(!request.JSON.amount) {
            respond (message:[[text:"improper amount given"]],resultCode:"ERROR")
            return
        }
        def payment
        try {
            payment = paymentsService.authorizeAndCapture(request.JSON)
        } catch (e) {
            respond (message:[[text:"error: " + e]],resultCode:"ERROR")
        }

        if(!payment) {
            respond (message:[[text:"transaction failed"]],resultCode:"ERROR")
            return
        }

        respond (payment.messages)
    }
}
