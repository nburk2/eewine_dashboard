package dashboard.fuelaccounts

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AccountsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Accounts.list(params), model:[accountsCount: Accounts.count()]
    }

    def show(Accounts accounts) {
        respond accounts
    }

    def create() {
        respond new Accounts(params)
    }

    @Transactional
    def save(Accounts accounts) {
        if (accounts == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (accounts.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond accounts.errors, view:'create'
            return
        }

        accounts.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'accounts.label', default: 'Accounts'), accounts.id])
                redirect accounts
            }
            '*' { respond accounts, [status: CREATED] }
        }
    }

    def edit(Accounts accounts) {
        respond accounts
    }

    @Transactional
    def update(Accounts accounts) {
        if (accounts == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (accounts.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond accounts.errors, view:'edit'
            return
        }

        accounts.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'accounts.label', default: 'Accounts'), accounts.id])
                redirect accounts
            }
            '*'{ respond accounts, [status: OK] }
        }
    }

    @Transactional
    def delete(Accounts accounts) {

        if (accounts == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        accounts.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'accounts.label', default: 'Accounts'), accounts.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'accounts.label', default: 'Accounts'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
