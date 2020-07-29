package dashboard.data

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK
import com.bertramlabs.plugins.SSLRequired
import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_ADMIN"])
@SSLRequired
class DriverTankController {

    def driverTankService

    def index() {
        Date scheduledDate = params.scheduledDate ? params.getDate("scheduledDate") : new Date()

        [driverTankList:DriverTank.findByScheduledDay(scheduledDate),scheduledDate:scheduledDate]
    }

    def create() {
        respond new DriverTank()
    }


    def save(DriverTank driverTank) {
        if (driverTank == null) {
            notFound()
            return
        }

        driverTank.save(flush:true)

        if(driverTank.hasErrors()){
            flash.errors = driverTank.errors.allErrors.collect { [message: g.message([error: it])] }
            respond driverTank, view:'create', model: []
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'driverTank.label', default: 'DriverTank'), [driverTank.id]])
                redirect driverTank
            }
            '*' { respond driverTank, [status: CREATED] }
        }
    }

    def edit(DriverTank driverTank) {
        if (driverTank == null) {
            notFound()
            return
        }

        respond driverTank
    }

    def show(DriverTank driverTank) {
        respond driverTank
    }

    def update(DriverTank driverTank) {
        if (driverTank == null) {
            notFound()
            return
        }

        driverTank.save(flush:true)

        if(driverTank.hasErrors()){
            flash.errors = driverTank.errors.allErrors.collect { [message: g.message([error: it])] }
            redirect action:"edit", id:params.id
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'driverTank.label', default: 'DriverTank'), [driverTank.id]])
                redirect driverTank
            }
            '*' { respond driverTank, [status: OK] }
        }
    }

    def delete(DriverTank driverTank) {
        if (driverTank == null) {
            notFound()
            return
        }
        def driverTankId = driverTank.id
        driverTank.delete(flush: true)

        if(driverTank.hasErrors()){
            flash.errors = driverTank.errors.allErrors.collect { [message: g.message([error: it])] }
            redirect action:"show", id:params.id
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'driverTank.label', default: 'DriverTank'), [driverTankId]])
                redirect action: "index", method: "GET"
            }
            '*' { respond driverTank, [status: OK] }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'driverTank.label', default: 'DriverTank'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
