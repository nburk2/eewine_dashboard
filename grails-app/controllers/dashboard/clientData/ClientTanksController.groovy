package dashboard.clientData

import com.bertramlabs.plugins.SSLRequired
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.OK
import org.springframework.web.multipart.MultipartFile

@Secured(["ROLE_ADMIN"])
@SSLRequired
class ClientTanksController {

    def clientTanksService

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

        def tankId = tank.id
        clientTanksService.deleteTankImage(tank)

        tank.delete(flush: true)

        if(tank.hasErrors()){
            flash.errors = tank.errors.allErrors.collect { [message: g.message([error: it])] }
            redirect action:"show", id:params.id
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = "deleted tank id: " + tankId
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

    def uploadTankImage(ClientTanks tank) {
        render view:"uploadTankImage", model: [tank:tank, errors:false]
    }

    def uploadTankImageFile(ClientTanks tank) {
        MultipartFile multipartFile = request.getFile('tankImage')

        if(!multipartFile) {
            flash.message = "no file found"
            redirect action: "uploadTankImage", id:tank.id
            return
        }

        try {
            clientTanksService.uploadTankImage(multipartFile, tank.id)
            tank.imageUrl = "https://tank-images.s3.amazonaws.com/" + tank.id + "tankImage"
            tank.save(flush:true)
        } catch (e) {
            println "the errors: " + e
            render view: "uploadTankImage", model: [tank:tank, errors:true, error:e]
            return
        }

        redirect action:"show", id:tank.id
    }

    def uploadTanks() {
        render view:"uploadTanks", model: [errors:false]
    }

    def uploadTanksFile() {
        def file = request.getFile('tanks')

        if(!file) {
            flash.message = "no file found"
            redirect action: "index"
            return
        }

        try {
            clientTanksService.uploadTanks(file)
        } catch (e) {
            println "the errors: " + e
            render view: "uploadTanks", model: [errors:true, error:e]
            return
        }

        redirect action: "index"
    }

    def findTanks() {
        def inputFieldsList = ["","Address","Location","Tank Ownership","Serial Number","Manufacturer","Size","Type","Product","Color","Paint Condition","Comments","Properly Labeled - YES","Properly Labeled - NO","Tertiary Containment - YES","Tertiary Containment - NO","Painted - YES","Painted - NO","Wine Energy Logo - YES","Wine Energy Logo - NO","Ecogreen - YES","Ecogreen - NO","Tank Gauge - YES","Tank Gauge - NO"]
        def inputField = params.inputField ?: ""
        def currentAccountField = params.account ?: ""

        def tanks = clientTanksService.findTanks(params)
        render view:"findTanks", model: [errors:false, tanks:tanks,currentAccountField:currentAccountField, inputField:inputField, inputFieldsList:inputFieldsList]
    }
}
