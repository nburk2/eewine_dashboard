package dashboard

import dashboard.data.Driver
import dashboard.data.DriverTruck
import dashboard.data.Truck

class OfficeBoardController {

    def index() {
        [
                driverTruckList:DriverTruck.findAllByUseDate(new Date().clearTime()),
                driverList:Driver.list(),
                truckList:Truck.list()
        ]
    }
}
