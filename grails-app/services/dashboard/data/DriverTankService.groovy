package dashboard.data

import dashboard.fuelaccounts.Tanks
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

    def generateSpecificDay(Date newScheduleDay,Date specificDay) {

        def driverTanks = DriverTank.findAllByScheduledDay(specificDay)
        def newDriverTanks = []

        driverTanks.each{driverTank ->
            def newDriverTank = new DriverTank(driverTank.properties)
            newDriverTank.scheduledDay = newScheduleDay
            newDriverTank.save(flush:true)
            newDriverTanks << newDriverTank

        }

        return newDriverTanks
    }

    def getTanksByDay(Date day) {
        def usedDriverTanks = DriverTank.findAllByScheduledDay(day)
        def usedTankIds =[]
        usedDriverTanks.each{ driverTanks ->
            driverTanks.tanks.each{tank->
                usedTankIds << tank.id
            }
        }

        def tanks = []
        def dayValue = day.day
        switch (dayValue) {
            case 1:
                Tanks.findAllBySundayAndIdNotInList(true,usedTankIds,[sort:"account.name"]);
                break;
            case 2:
                Tanks.findAllByMondayAndIdNotInList(true,usedTankIds,[sort:"account.name"]);
                break;
            case 3:
                Tanks.findAllByTuesdayAndIdNotInList(true,usedTankIds,[sort:"account.name"]);
                break;
            case 4:
                Tanks.findAllByWednesdayAndIdNotInList(true,usedTankIds,[sort:"account.name"]);
                break;
            case 5:
                Tanks.findAllByThursdayAndIdNotInList(true,usedTankIds,[sort:"account.name"]);
                break;
            case 6:
                Tanks.findAllByFridayAndIdNotInList(true,usedTankIds,[sort:"account.name"]);
                break;
            case 7:
                Tanks.findAllBySaturdayAndIdNotInList(true,usedTankIds,[sort:"account.name"]);
                break;
            default: println "Something else";
        }
        return tanks
    }
}
