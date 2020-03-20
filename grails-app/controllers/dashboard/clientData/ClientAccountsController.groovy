package dashboard.clientData

import com.bertramlabs.plugins.SSLRequired
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.OK

@Secured(["ROLE_ADMIN"])
@SSLRequired
class ClientAccountsController {

    def index() {
        [accountList:ClientAccounts.list(sort:params.sort,order:params.order)]
    }

    def create() {
        def account = new ClientAccounts()
        [account:account]
    }

    def show(ClientAccounts account) {
        [account:account]
    }

    def save(ClientAccounts account) {
        if (account == null) {
            notFound()
            return
        }

        account.save()

        if(account.hasErrors()){
            flash.errors = account.errors.allErrors.collect { [message: g.message([error: it])] }
            respond account, view:'create', model: [account:account]
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'clientaccount.label', default: 'ClientAccounts'), [account.name]])
                redirect account
            }
            '*' { respond account, [status: CREATED] }
        }
    }

    def edit(ClientAccounts account) {
        if (account == null) {
            notFound()
            return
        }

        [account:account]
    }

    def update(ClientAccounts account) {
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
                flash.message = message(code: 'default.updated.message', args: [message(code: 'clientaccount.label', default: 'ClientAccounts'), [account.name]])
                redirect account
            }
            '*' { respond account, [status: OK] }
        }
    }

    def delete(ClientAccounts account) {
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
                flash.message = message(code: 'default.created.message', args: [message(code: 'clientaccount.label', default: 'ClientAccounts'), [accountName]])
                redirect action: "index", method: "GET"
            }
            '*' { respond account, [status: OK] }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'clientaccount.label', default: 'ClientAccounts'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
