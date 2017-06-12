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
        initUsers()
        new Note([message:"This is the default message"]).save()
    }

    private void initUsers() {
        def adminRole      = Role.findOrSaveByAuthority('ROLE_ADMIN')
        def managerRole    = Role.findOrSaveByAuthority('ROLE_MANAGER')
        def userRole  = Role.findOrSaveByAuthority('ROLE_USER')

        assert adminRole && managerRole && userRole

        //noinspection GroovyAssignabilityCheck
        String adminUserName = "admin"
//        String adminUserName = config.springsecurity.syndicationAdmin.adminUsername
        if (User.findByUsername(adminUserName)) {
            return
        }

//        String initialPassword = config.springsecurity.syndicationAdmin.initialAdminPassword
        println "bootstrap var: " + config
        println "bootstrap var: " + config.MYSQL_USERNAME
        String initialPassword = "ABC123def"

        def adminUser = new User(username: adminUserName, enabled: true, password: initialPassword)
        adminUser.save(flush: true)
        println "user errors: " + adminUser.errors

        UserRole.create adminUser, adminRole, true
    }
}
