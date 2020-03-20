package dashboard.clientData

import com.bertramlabs.plugins.SSLRequired
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.OK

@Secured(["ROLE_ADMIN"])
@SSLRequired
class ClientTanksController {

    def index() {
        [tankList:ClientTanks.list(sort:params.sort,order:params.order)]
    }

    def create() {
        def tank = new ClientTanks()
        [tank:tank]
    }

    def show(ClientTanks tank) {
        [tank:tank]
    }

    def save(ClientTanks tank) {
        if (tank == null) {
            notFound()
            return
        }

        tank.save()

        if(tank.hasErrors()){
            println tank.errors
            flash.errors = tank.errors.allErrors.collect { [message: g.message([error: it])] }
            respond tank, view:'create', model: [tank:tank]
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'clienttank.label', default: 'ClientTanks'), [tank.number]])
                redirect tank
            }
            '*' { respond tank, [status: CREATED] }
        }
    }

    def edit(ClientTanks tank) {
        if (tank == null) {
            notFound()
            return
        }

        [tank:tank]
    }

    def update(ClientTanks tank) {
        if (tank == null) {
            notFound()
            return
        }

        tank.save(flush:true)

        if(tank.hasErrors()){
            flash.errors = tank.errors.allErrors.collect { [message: g.message([error: it])] }
            redirect action:"edit", id:params.id
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'clienttank.label', default: 'ClientTanks'), [tank.number]])
                redirect tank
            }
            '*' { respond tank, [status: OK] }
        }
    }

    def delete(ClientTanks tank) {
        if (tank == null) {
            notFound()
            return
        }
        def tankNumber = tank.number
        tank.delete(flush: true)

        if(tank.hasErrors()){
            flash.errors = tank.errors.allErrors.collect { [message: g.message([error: it])] }
            redirect action:"show", id:params.id
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'clienttank.label', default: 'ClientTanks'), [tankNumber]])
                redirect action: "index", method: "GET"
            }
            '*' { respond tank, [status: OK] }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'clienttank.label', default: 'ClientTanks'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
