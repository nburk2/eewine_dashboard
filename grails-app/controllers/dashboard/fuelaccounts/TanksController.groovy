package dashboard.fuelaccounts

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TanksController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Tanks.list(params), model:[tanksCount: Tanks.count()]
    }

    def show(Tanks tanks) {
        respond tanks
    }

    def create() {
        respond new Tanks(params)
    }

    @Transactional
    def save(Tanks tanks) {
        if (tanks == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tanks.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tanks.errors, view:'create'
            return
        }

        tanks.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tanks.label', default: 'Tanks'), tanks.id])
                redirect tanks
            }
            '*' { respond tanks, [status: CREATED] }
        }
    }

    def edit(Tanks tanks) {
        respond tanks
    }

    @Transactional
    def update(Tanks tanks) {
        if (tanks == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tanks.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tanks.errors, view:'edit'
            return
        }

        tanks.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tanks.label', default: 'Tanks'), tanks.id])
                redirect tanks
            }
            '*'{ respond tanks, [status: OK] }
        }
    }

    @Transactional
    def delete(Tanks tanks) {

        if (tanks == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        tanks.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tanks.label', default: 'Tanks'), tanks.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tanks.label', default: 'Tanks'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
