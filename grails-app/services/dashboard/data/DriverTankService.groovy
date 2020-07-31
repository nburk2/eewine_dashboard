package dashboard.data

import grails.transaction.Transactional

@Transactional
class DriverTankService {

    def generateLastWeeksDay(Date day) {

        def driverTanks = DriverTank.findAllByScheduledDay(day - 7)
        def newDriverTanks = []

        driverTanks.each{driverTank ->
            def newDriverTank = new DriverTank(driverTank.properties)
            newDriverTank.scheduledDay = day
            newDriverTank.save(flush:true)
            newDriverTanks << newDriverTank

        }

        return newDriverTanks
    }
}
