package dashboard

import dashboard.authentication.UserRole
import dashboard.data.Driver
import dashboard.data.DriverAccount
import dashboard.data.DriverTruck
import dashboard.data.Note
import dashboard.data.Truck
import grails.plugin.springsecurity.annotation.Secured
import com.bertramlabs.plugins.SSLRequired

class OfficeBoardController {

    @Secured(["ROLE_ADMIN"])
    @SSLRequired
    def index() {
        [
                driverTruckList:DriverTruck.list(),
                driverList:Driver.list(),
                truckList:Truck.list(),
                driverAccounts:DriverAccount.list(),
                noteList:Note.findAllByUseFromLessThanEqualsAndUseToGreaterThanEquals(new Date().clearTime(), (new Date() + 1).clearTime())
        ]
    }

    @Secured(["permitAll"])
    def pingTest() {

    }
}
