package dashboard

import dashboard.authentication.Role
import dashboard.authentication.User
import dashboard.authentication.UserRole
import dashboard.data.Account
import dashboard.data.Driver
import dashboard.data.DriverAccount
import dashboard.data.DriverTruck
import dashboard.data.Note
import dashboard.data.Truck

class BootStrap {

    def init = { servletContext ->
        testData()
    }
    def destroy = {
    }
}
