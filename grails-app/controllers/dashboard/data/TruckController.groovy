package dashboard.data

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.OK

class TruckController {

    def index() {
        [truckList:Truck.list()]
    }

    def create() {
        respond new Truck()
    }


    def save(Truck truck) {
        if (truck == null) {
            notFound()
            return
        }

        truck.save()

        if(truck.hasErrors()){
            flash.errors = truck.errors.allErrors.collect { [message: g.message([error: it])] }
            respond truck, view:'create', model: []
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'truck.label', default: 'Truck'), [truck.number]])
                redirect truck
            }
            '*' { respond truck, [status: CREATED] }
        }
    }

    def edit(Truck truck) {
        if (truck == null) {
            notFound()
            return
        }

        respond truck
    }

    def show(Truck truck) {
        respond truck
    }

    def update(Truck truck) {
        if (truck == null) {
            notFound()
            return
        }

        truck.save(flush:true)

        if(truck.hasErrors()){
            flash.errors = truck.errors.allErrors.collect { [message: g.message([error: it])] }
            redirect action:"edit", id:params.id
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'truck.label', default: 'Truck'), [truck.number]])
                redirect truck
            }
            '*' { respond truck, [status: OK] }
        }
    }

    def delete(Truck truck) {
        if (truck == null) {
            notFound()
            return
        }
        def truckNumber = truck.number
        truck.delete(flush: true)

        if(truck.hasErrors()){
            flash.errors = truck.errors.allErrors.collect { [message: g.message([error: it])] }
            redirect action:"show", id:params.id
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'truck.label', default: 'Truck'), [truckNumber]])
                redirect action: "index", method: "GET"
            }
            '*' { respond truck, [status: OK] }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'truck.label', default: 'Truck'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
