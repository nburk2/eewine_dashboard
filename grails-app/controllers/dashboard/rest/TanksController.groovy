package dashboard.rest

import dashboard.fuelaccounts.Accounts
import dashboard.fuelaccounts.Tanks

import com.bertramlabs.plugins.SSLRequired
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK

@Secured(["permitAll"])
@SSLRequired
@Transactional
class TanksController {

    static allowedMethods = [getTanks:"POST",addTanks: "POST",editTank:"POST",save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        if(params.accountNumber) {
            Accounts account = Accounts.findByNumber(params.getInt("accountNumber"))
            println account
            if(account == null) {
                render view:"index", model:[tanksList: [],tanksCount: 0,error:"Could Not find Account: " + params.accountNumber]
                return
            }
            params.max = Math.min(max ?: 10, 100)
            [tanksList:Tanks.findAllByAccount(account,params),tanksCount: Tanks.countByAccount(account,params)]
        } else {
            params.max = Math.min(max ?: 10, 100)
            [tanksList:Tanks.list(params),tanksCount: Tanks.count()]
        }
    }

    def show(Tanks tanks) {
        respond tanks
    }

    def create() {
        respond new Tanks(params)
    }

    @Transactional
    def save(Tanks tanks) {
        if (tanks == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tanks.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tanks.errors, view:'create'
            return
        }

        tanks.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tanks.label', default: 'Tanks'), tanks.id])
                redirect tanks
            }
            '*' { respond tanks, [status: CREATED] }
        }
    }

    def edit(Tanks tanks) {
        respond tanks
    }

    @Transactional
    def update(Tanks tanks) {
        if (tanks == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tanks.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tanks.errors, view:'edit'
            return
        }

        tanks.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tanks.label', default: 'Tanks'), tanks.id])
                redirect tanks
            }
            '*'{ respond tanks, [status: OK] }
        }
    }

    @Transactional
    def delete(Tanks tanks) {

        if (tanks == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        tanks.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tanks.label', default: 'Tanks'), tanks.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tanks.label', default: 'Tanks'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

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

        newTank.poNumber = tank.poNumber

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
