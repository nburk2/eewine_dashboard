package dashboard

import dashboard.data.DriverTruck

class OfficeBoardController {

    def index() {
        [driverTruckList:DriverTruck.findAllByUseDate(new Date().clearTime())]
    }
}
