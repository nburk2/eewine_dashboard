package dashboard.data

import com.bertramlabs.plugins.SSLRequired
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Secured(["ROLE_ADMIN"])
@SSLRequired
@Transactional(readOnly = true)
class WinotstopController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE", getDataEntry: "GET"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Winotstop.list(params), model:[winotstopCount: Winotstop.count()]
    }

    def show(Winotstop winotstop) {
        respond winotstop
    }

    def create() {
        respond new Winotstop(params)
    }

    @Transactional
    def save(Winotstop winotstop) {
        if (winotstop == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (winotstop.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond winotstop.errors, view:'create'
            return
        }

        winotstop.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'winotstop.label', default: 'Winotstop'), winotstop.id])
                redirect winotstop
            }
            '*' { respond winotstop, [status: CREATED] }
        }
    }

    def edit(Winotstop winotstop) {
        respond winotstop
    }

    @Transactional
    def update(Winotstop winotstop) {
        if (winotstop == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (winotstop.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond winotstop.errors, view:'edit'
            return
        }

        winotstop.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'winotstop.label', default: 'Winotstop'), winotstop.id])
                redirect winotstop
            }
            '*'{ respond winotstop, [status: OK] }
        }
    }

    @Transactional
    def delete(Winotstop winotstop) {

        if (winotstop == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        winotstop.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'winotstop.label', default: 'Winotstop'), winotstop.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    @Secured(["permitAll"])
    def getDataEntry(String name) {
        def entry = Winotstop.findByName(name)

        if(!entry) {
            def error = [error: "not found"]
            respond error
        }

        respond Winotstop.findByName(name), view: "entry"
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'winotstop.label', default: 'Winotstop'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
