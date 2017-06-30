package dashboard.data

import com.bertramlabs.plugins.SSLRequired
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Secured(["ROLE_ADMIN"])
@SSLRequired
@Transactional(readOnly = true)
class WineEnergyController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond WineEnergy.list(params), model:[wineEnergyCount: WineEnergy.count()]
    }

    def show(WineEnergy wineEnergy) {
        respond wineEnergy
    }

    def create() {
        respond new WineEnergy(params)
    }

    @Transactional
    def save(WineEnergy wineEnergy) {
        if (wineEnergy == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (wineEnergy.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond wineEnergy.errors, view:'create'
            return
        }

        wineEnergy.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'wineEnergy.label', default: 'WineEnergy'), wineEnergy.id])
                redirect wineEnergy
            }
            '*' { respond wineEnergy, [status: CREATED] }
        }
    }

    def edit(WineEnergy wineEnergy) {
        respond wineEnergy
    }

    @Transactional
    def update(WineEnergy wineEnergy) {
        if (wineEnergy == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (wineEnergy.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond wineEnergy.errors, view:'edit'
            return
        }

        wineEnergy.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'wineEnergy.label', default: 'WineEnergy'), wineEnergy.id])
                redirect wineEnergy
            }
            '*'{ respond wineEnergy, [status: OK] }
        }
    }

    @Transactional
    def delete(WineEnergy wineEnergy) {

        if (wineEnergy == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        wineEnergy.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'wineEnergy.label', default: 'WineEnergy'), wineEnergy.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    @Secured(["permitAll"])
    def getDataEntry(String name) {
        def entry = WineEnergy.findByName(name)

        if(!entry) {
            def error = [error: "not found"]
            respond error
        }

        respond WineEnergy.findByName(name), view: "entry"
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'wineEnergy.label', default: 'WineEnergy'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
