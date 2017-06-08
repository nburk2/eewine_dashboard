package dashboard

import dashboard.data.Driver
import dashboard.data.DriverAccount
import dashboard.data.DriverTruck
import dashboard.data.Note
import dashboard.data.Truck

class OfficeBoardController {

    def index() {
        [
                driverTruckList:DriverTruck.list(),
                driverList:Driver.list(),
                truckList:Truck.list(),
                driverAccounts:DriverAccount.list(),
                noteList:Note.findAllByUseFromGreaterThanEqualsAndUseToLessThanEquals(new Date().clearTime(), (new Date() + 1).clearTime())
        ]
    }
}
