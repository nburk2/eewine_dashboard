package dashboard.rest

import dashboard.fuelaccounts.Accounts

import com.bertramlabs.plugins.SSLRequired
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK

@Secured(["permitAll"])
@SSLRequired
@Transactional
class AccountsController {

    static allowedMethods = [getAccounts:"POST",addAccounts: "POST",editAccount:"POST",findByBillingType:"POST",save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond model:[accountsList:Accounts.list(params),accountsCount: Accounts.count()]
    }

    def show(Accounts accounts) {
        respond accounts
    }

    def create() {
        respond new Accounts(params)
    }

    @Transactional
    def save(Accounts accounts) {
        if (accounts == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (accounts.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond accounts.errors, view:'create'
            return
        }

        accounts.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'accounts.label', default: 'Accounts'), accounts.id])
                redirect accounts
            }
            '*' { respond accounts, [status: CREATED] }
        }
    }

    def edit(Accounts accounts) {
        respond accounts
    }

    @Transactional
    def update(Accounts accounts) {
        if (accounts == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (accounts.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond accounts.errors, view:'edit'
            return
        }

        accounts.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'accounts.label', default: 'Accounts'), accounts.id])
                redirect accounts
            }
            '*'{ respond accounts, [status: OK] }
        }
    }

    @Transactional
    def delete(Accounts accounts) {

        if (accounts == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        accounts.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'accounts.label', default: 'Accounts'), accounts.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'accounts.label', default: 'Accounts'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def getAccounts() {
        def accounts
        if(request.JSON?.accountNumber) {
            int num = request.JSON.accountNumber.toInteger()
            accounts = Accounts.findAllByNumber(num,[sort:"number"])
        } else if(request.JSON?.addFilter == "true") {
            def numberList = request.JSON?.accountList?.number ?: []
            if(request.JSON?.sendEmail) {
                boolean sendEmail = request.JSON?.sendEmail?.toBoolean()
                accounts = Accounts.findAllByNumberInListAndSendEmail(numberList,sendEmail,[sort:"number"])
            } else {
                accounts = Accounts.findAllByNumberInList(numberList,[sort:"number"])
            }
        } else {
            accounts = Accounts.findAllBydiscontinued(false,[sort:"number"])
        }

        def tanks = accounts.tanks
        def assets = accounts.assets

        respond([status:200, assets:assets, tanks:tanks, accounts:accounts, accountNumbers:accounts.number])

    }

    def addAccounts() {
        def accounts = request.JSON.accounts
        println(Accounts.list().size())
        accounts.each { account ->
            def newAccount = new Accounts()
            newAccount.name = account.firstName + " " + account.lastName
            newAccount.number = account.number
            newAccount.discontinued = false
            newAccount.standard = false
            newAccount.mansfield = false
            newAccount.mansfieldTank = false
            newAccount.fuelAll = false
            newAccount.standardWeekly = false
            newAccount.standardBiWeekly = false
            newAccount.standardMonthly = false
            newAccount.reston = false
            newAccount.specialExport = false
            newAccount.phoenix = false
            newAccount.mclean = false
            newAccount.worldFuel = false
            newAccount.comdata = false
            newAccount.comdataMileage = false
            newAccount.sendEmail = false
            newAccount.print = false

            newAccount.save()

        }

        Map result = [status:200, message:"imported all accounts"]

        render(view:"addAccounts", model:[result:result])
    }

    def editAccount() {
        def account = request.JSON.account
        def newAccount = Accounts.findByNumber(account.number.toInteger())

//        newAccount.name = account.name - don't change name
//        newAccount.number = account.number - don't change number
        newAccount.sendEmail = account.sendEmail.toBoolean()
        newAccount.print = account.print.toBoolean()
        newAccount.standard = account.standard.toBoolean()
        newAccount.mansfield = account.mansfield.toBoolean()
        newAccount.mansfieldTank = account.mansfieldTank.toBoolean()
        newAccount.fuelAll = account.fuelAll.toBoolean()
        newAccount.standardWeekly = account.standardWeekly.toBoolean()
        newAccount.standardBiWeekly = account.standardBiWeekly.toBoolean()
        newAccount.standardMonthly = account.standardMonthly.toBoolean()
        newAccount.reston = account.reston.toBoolean()
        newAccount.specialExport = account.specialExport.toBoolean()
        newAccount.phoenix = account.phoenix.toBoolean()
        newAccount.mclean = account.mclean.toBoolean()
        newAccount.worldFuel = account.worldFuel.toBoolean()
        newAccount.comdata = account.comdata.toBoolean()
        newAccount.comdataMileage = account.comdataMileage.toBoolean()
        newAccount.save(flush:true, failOnError: true)

        Map result = [status:200, message:"updated account: " + newAccount.name]

        render(view:"editAccount",model:[result:result])
    }

    def editAccountReport() {
        def account = request.JSON.account
        def newAccount = Accounts.findByNumber(account.number.toInteger())

//        newAccount.name = account.name - don't change name
//        newAccount.number = account.number - don't change number
        newAccount.sendReportEmail = account.sendReportEmail.toBoolean()
        newAccount.printReport = account.printReport.toBoolean()
        newAccount.includePrice = account.includePrice.toBoolean()
        newAccount.weekly = account.weekly.toBoolean()
        newAccount.biWeekly = account.biWeekly.toBoolean()
        newAccount.monthly = account.monthly.toBoolean()
        newAccount.quarterly = account.quarterly.toBoolean()

        newAccount.save(flush:true, failOnError: true)

        Map result = [status:200, message:"updated account: " + newAccount.name]

        render(view:"editAccount",model:[result:result])
    }

    def findByBillingType() {
        def billingType = request.JSON.billingType
        def accounts = []
        switch (billingType) {
            case "standard":
                accounts = Accounts.findAllByStandard(true)
                break
            case "mansfield":
                accounts = Accounts.findAllByMansfield(true)
                break
            case "mansfieldTank":
                accounts = Accounts.findAllByMansfieldTank(true)
                break
            case "fuelAll":
                accounts = Accounts.findAllByFuelAll(true)
                break
            case "standardWeekly":
                accounts = Accounts.findAllByStandardWeekly(true)
                break
            case "standardBiWeekly":
                accounts = Accounts.findAllByStandardBiWeekly(true)
                break
            case "standardMonthly":
                accounts = Accounts.findAllByStandardMonthly(true)
                break
            case "reston":
                accounts = Accounts.findAllByReston(true)
                break
            case "specialExport":
                accounts = Accounts.findAllBySpecialExport(true)
                break
            case "phoenix":
                accounts = Accounts.findAllByPhoenix(true)
                break
            case "mclean":
                accounts = Accounts.findAllByMclean(true)
                break
            case "worldFuel":
                accounts = Accounts.findAllByWorldFuel(true)
                break
            case "comdata":
                accounts = Accounts.findAllByComdata(true)
                break
            case "comdataMileage":
                accounts = Accounts.findAllByComdataMileage(true)
                break
            case "weekly":
                accounts = Accounts.findAllByWeekly(true)
                break
            case "biWeekly":
                accounts = Accounts.findAllByBiWeekly(true)
                break
            case "monthly":
                accounts = Accounts.findAllByMonthly(true)
                break
            case "quarterly":
                accounts = Accounts.findAllByQuarterly(true)
                break
        }

        def tanks = accounts.tanks

        respond([status:200, tanks:tanks, accounts:accounts, accountNumbers:accounts.number])
    }
}