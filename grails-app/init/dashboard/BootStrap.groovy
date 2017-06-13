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
import grails.util.Holders

class BootStrap {
    def config = Holders.config

    def init = { servletContext ->
        testData()
    }
    def destroy = {
    }

    def testData() {
        if(User.count == 0) {
            initUsers()
        }
    }

    private void initUsers() {
        def adminRole      = Role.findOrSaveByAuthority('ROLE_ADMIN')
        def managerRole    = Role.findOrSaveByAuthority('ROLE_MANAGER')
        def userRole  = Role.findOrSaveByAuthority('ROLE_USER')

        assert adminRole && managerRole && userRole

        //noinspection GroovyAssignabilityCheck
        String adminUserName = config.EEWINE_ADMIN_USERNAME ?: "admin"
        if (User.findByUsername(adminUserName)) {
            return
        }

        String initialPassword = config.EEWINE_ADMIN_PASSWORD ?: "ABC123def"

        def adminUser = new User(username: adminUserName, enabled: true, password: initialPassword)
        adminUser.save(flush: true)

        UserRole.create adminUser, adminRole, true
    }
}
