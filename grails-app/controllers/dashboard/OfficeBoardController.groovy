package dashboard

import dashboard.authentication.Role
import dashboard.authentication.UserRole
import dashboard.data.Driver
import dashboard.data.DriverAccount
import dashboard.data.DriverTruck
import dashboard.data.Note
import dashboard.data.Truck
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import com.bertramlabs.plugins.SSLRequired

class OfficeBoardController {

    def officeBoardService
    def springSecurityService

    @Secured(["ROLE_ADMIN","ROLE_DRIVER"])
    @SSLRequired
    def index() {
        if(springSecurityService.getPrincipal().getAuthorities()[0].authority == "ROLE_DRIVER") {
            redirect(uri:"/veederRoot/ninetyPercentages")
            return
        }
        officeBoardService.getWeather()
        [
                driverTruckList:DriverTruck.list(),
                driverList:Driver.list(sort:"lastName"),
                truckList:Truck.list(sort:"number"),
                driverAccounts:DriverAccount.list(),
                noteList:Note.findAllByUseFromLessThanEqualsAndUseToGreaterThanEquals(new Date().clearTime(), (new Date() + 1).clearTime()),
                forecastMap:officeBoardService.getWeather()
        ]
    }

    @Secured(["permitAll"])
    def pingTest() {
        
    }

    @Secured(["ROLE_ADMIN"])
    def getLocations() {
        def locations = officeBoardService.getVehicleLocations()

        render locations as JSON
    }
}
