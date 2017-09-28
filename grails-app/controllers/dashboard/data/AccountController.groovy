package dashboard.data

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.OK
import grails.plugin.springsecurity.annotation.Secured
import com.bertramlabs.plugins.SSLRequired

@Secured(["ROLE_ADMIN"])
@SSLRequired
class AccountController {

    def index() {
        [accountList:Account.list(sort:"name")]
    }

    def create() {
        respond new Account()
    }

    def save(Account account) {
        if (account == null) {
            notFound()
            return
        }

        account.save()

        if(account.hasErrors()){
            flash.errors = account.errors.allErrors.collect { [message: g.message([error: it])] }
            respond account, view:'create', model: []
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'account.label', default: 'Account'), [account.name]])
                redirect account
            }
            '*' { respond account, [status: CREATED] }
        }
    }

    def edit(Account account) {
        if (account == null) {
            notFound()
            return
        }

        respond account
    }

    def show(Account account) {
        respond account
    }

    def update(Account account) {
        if (account == null) {
            notFound()
            return
        }

        account.save(flush:true)

        if(account.hasErrors()){
            flash.errors = account.errors.allErrors.collect { [message: g.message([error: it])] }
            redirect action:"edit", id:params.id
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'account.label', default: 'Account'), [account.name]])
                redirect account
            }
            '*' { respond account, [status: OK] }
        }
    }

    def delete(Account account) {
        if (account == null) {
            notFound()
            return
        }
        def accountName = account.name
        account.delete(flush: true)

        if(account.hasErrors()){
            flash.errors = account.errors.allErrors.collect { [message: g.message([error: it])] }
            redirect action:"show", id:params.id
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'account.label', default: 'Account'), [accountName]])
                redirect action: "index", method: "GET"
            }
            '*' { respond account, [status: OK] }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'account.label', default: 'Account'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
