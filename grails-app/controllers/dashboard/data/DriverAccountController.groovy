package dashboard.data

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.OK

class DriverAccountController {

    def index() {
        [driverAccountList:DriverAccount.list()]
    }

    def create() {
        respond new DriverAccount()
    }


    def save(DriverAccount driverAccount) {
        if (driverAccount == null) {
            notFound()
            return
        }

        driverAccount.save()
println "errors: " + driverAccount.errors
        if(driverAccount.hasErrors()){
            flash.errors = driverAccount.errors.allErrors.collect { [message: g.message([error: it])] }
            respond driverAccount, view:'create', model: []
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'driverAccount.label', default: 'DriverAccount'), [driverAccount.id]])
                redirect driverAccount
            }
            '*' { respond driverAccount, [status: CREATED] }
        }
    }

    def edit(DriverAccount driverAccount) {
        if (driverAccount == null) {
            notFound()
            return
        }

        respond driverAccount
    }

    def show(DriverAccount driverAccount) {
        respond driverAccount
    }

    def update(DriverAccount driverAccount) {
        if (driverAccount == null) {
            notFound()
            return
        }

        driverAccount.save(flush:true)

        if(driverAccount.hasErrors()){
            flash.errors = driverAccount.errors.allErrors.collect { [message: g.message([error: it])] }
            redirect action:"edit", id:params.id
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'driverAccount.label', default: 'DriverAccount'), [driverAccount.id]])
                redirect driverAccount
            }
            '*' { respond driverAccount, [status: OK] }
        }
    }

    def delete(DriverAccount driverAccount) {
        if (driverAccount == null) {
            notFound()
            return
        }
        def driverAccountId = driverAccount.id
        driverAccount.delete(flush: true)

        if(driverAccount.hasErrors()){
            flash.errors = driverAccount.errors.allErrors.collect { [message: g.message([error: it])] }
            redirect action:"show", id:params.id
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'driverAccount.label', default: 'DriverAccount'), [driverAccountId]])
                redirect action: "index", method: "GET"
            }
            '*' { respond driverAccount, [status: OK] }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'driverAccount.label', default: 'DriverAccount'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
