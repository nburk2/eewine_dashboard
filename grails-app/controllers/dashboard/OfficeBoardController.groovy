package dashboard

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

    @Secured(["ROLE_ADMIN"])
    @SSLRequired
    def index() {
        officeBoardService.getWeather()
        [
                driverTruckList:DriverTruck.list(),
                driverList:Driver.list(),
                truckList:Truck.list(),
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
