package dashboard.rest

import dashboard.fuelaccounts.Accounts
import dashboard.fuelaccounts.Tanks

import com.bertramlabs.plugins.SSLRequired
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Secured(["permitAll"])
//@SSLRequired
@Transactional
class TanksController {

    static allowedMethods = [getTanks:"POST",addTanks: "POST",editTank:"POST"]

    def index() { }

    def addTanks() {
        def tanks = request.JSON.tanks
        tanks.each { tank ->
            def newTank = new Tanks()
            newTank.tankNum = tank.tankNumber
//            newTank.poNumber = tank.poNumber
            newTank.account = Accounts.findByNumber(tank.accountNumber.toInteger())

            newTank.save()

        }

        respond([status:200, message:"added new accounts"])
    }

    def getTanks() {
        int num = request.JSON.accountNumber.toInteger()
        Accounts account = Accounts.findByNumber(num)
        def tanks = Tanks.findAllByAccount(account,[sort:"tankNum"])

        println(tanks[0])

        respond([status:200, account:account, tanks:tanks])
    }

    def editTank() {
        def tank = request.JSON.tank
        def account = Accounts.findById(tank.accountId.toInteger())
        def newTank = Tanks.findByTankNumAndAccount(tank.tankNum.toInteger(), account)

        //world fuel
        if(tank.billTo || tank.siteId) {
            newTank.billTo = tank.billTo
            newTank.siteId = tank.siteId
        }
        //specialExport
        if(tank.cardNumber) {
            newTank.cardNumber = tank.cardNumber
        }

        //mansfield
        if(tank.customerNumber || tank.shipTo || tank.supplierCode) {
            newTank.customerNumber = tank.customerNumber
            newTank.shipTo = tank.shipTo
            newTank.supplierCode = tank.supplierCode
        }

        newTank.save(flush:true, failOnError: true)
        if(newTank.hasErrors()) {
            println(newTank.erros)
        }

        respond([status:200, message:"updated Tank: " + newTank.tankNum])
    }
}
