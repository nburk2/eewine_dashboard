package dashboard.data

import java.awt.Color

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.NOT_FOUND
import grails.plugin.springsecurity.annotation.Secured
import com.bertramlabs.plugins.SSLRequired

@Secured(["ROLE_ADMIN"])
@SSLRequired
class DriverController {

    def index() {
        [driverList:Driver.list(sort:"firstName")]
    }

    def create() {
        respond new Driver()
    }


    def save(Driver driver) {
        if (driver == null) {
            notFound()
            return
        }

        driver.save()

        if(driver.hasErrors()){
            flash.errors = driver.errors.allErrors.collect { [message: g.message([error: it])] }
            respond driver, view:'create', model: []
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'driver.label', default: 'Driver'), [driver.firstName]])
                redirect driver
            }
            '*' { respond driver, [status: CREATED] }
        }
    }

    def edit(Driver driver) {
        if (driver == null) {
            notFound()
            return
        }

        respond driver
    }

    def show(Driver driver) {
        respond driver
    }

    def update(Driver driver) {
        if (driver == null) {
            notFound()
            return
        }

        driver.save(flush:true)

        if(driver.hasErrors()){
            flash.errors = driver.errors.allErrors.collect { [message: g.message([error: it])] }
            redirect action:"edit", id:params.id
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'driver.label', default: 'Driver'), [driver.firstName]])
                redirect driver
            }
            '*' { respond driver, [status: OK] }
        }
    }

    def delete(Driver driver) {
        if (driver == null) {
            notFound()
            return
        }
        def driverAccounts = DriverAccount.findAllByDriver(driver)
        driverAccounts.each { driverAccount ->
            driverAccount.delete()
        }
        def driverTrucks = DriverTruck.findAllByDriver(driver)
        driverTrucks.each { driverTruck ->
            driverTruck.delete()
        }
        def driverName = driver.firstName
        driver.delete(flush: true)

        if(driver.hasErrors()){
            flash.errors = driver.errors.allErrors.collect { [message: g.message([error: it])] }
            redirect action:"show", id:params.id
            return
        }

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'driver.label', default: 'Driver'), [driverName]])
                redirect  action: "index", method: "GET"
            }
            '*' { respond driver, [status: OK] }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'driver.label', default: 'Driver'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}