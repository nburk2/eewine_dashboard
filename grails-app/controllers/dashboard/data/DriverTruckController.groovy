package dashboard.data

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.OK
import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_ADMIN"])
class DriverTruckController {

    def index() {
        [driverTruckList:DriverTruck.list()]
    }

    def create() {
        respond new DriverTruck(), model: [driverTruckList: DriverTruck.list()]
    }

    def save(DriverTruck driverTruck) {
        if (driverTruck == null) {
            notFound()
            return
        }

        driverTruck.save()

        if(driverTruck.hasErrors()){
            flash.errors = driverTruck.errors.allErrors.collect { [message: g.message([error: it])] }
            respond driverTruck, view:'create', model: [driverTruckList: DriverTruck.list()]
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'driverTruck.label', default: 'DriverTruck'), [driverTruck.id]])
                redirect driverTruck
            }
            '*' { respond driverTruck, [status: CREATED] }
        }
    }

    def edit(DriverTruck driverTruck) {
        if (driverTruck == null) {
            notFound()
            return
        }

        respond driverTruck, model: [driverTruckList: DriverTruck.list()]
    }

    def show(DriverTruck driverTruck) {
        respond driverTruck
    }

    def update(DriverTruck driverTruck) {
        if (driverTruck == null) {
            notFound()
            return
        }

        driverTruck.save(flush:true)

        if(driverTruck.hasErrors()){
            flash.errors = driverTruck.errors.allErrors.collect { [message: g.message([error: it])] }
            redirect action:"edit", id:params.id
            return
        }

        println "errors update:" + params

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'driverTruck.label', default: 'DriverTruck'), [driverTruck.id]])
                redirect driverTruck
            }
            '*' { respond driverTruck, [status: OK] }
        }
    }

    def delete(DriverTruck driverTruck) {
        if (driverTruck == null) {
            notFound()
            return
        }
        def driverTruckId = driverTruck.id
        driverTruck.delete(flush: true)

        if(driverTruck.hasErrors()){
            flash.errors = driverTruck.errors.allErrors.collect { [message: g.message([error: it])] }
            redirect action:"show", id:params.id
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'driverTruck.label', default: 'DriverTruck'), [driverTruckId]])
                redirect action: "index", method: "GET"
            }
            '*' { respond driverTruck, [status: OK] }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'driverTruck.label', default: 'DriverTruck'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
