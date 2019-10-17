package dashboard.rest

import dashboard.fuelaccounts.Accounts

import com.bertramlabs.plugins.SSLRequired
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Secured(["permitAll"])
@SSLRequired
@Transactional
class AccountsController {

    static allowedMethods = [getAccounts:"POST",addAccounts: "POST",editAccount:"POST",findByBillingType:"POST"]

    def index() {

    }

    def getAccounts() {
        def accounts
        if(request.JSON?.accountNumber) {
            int num = request.JSON.accountNumber.toInteger()
            accounts = Accounts.findAllByNumber(num,[sort:"number"])
        } else if(request.JSON?.addFilter == "true") {
            def numberList = request.JSON?.accountList?.number ?: []
            accounts = Accounts.findAllByNumberInList(numberList,[sort:"number"])
        } else {
            accounts = Accounts.findAllByTerminated(false,[sort:"number"])
        }
        respond([status:200, accounts:accounts])

    }

    def addAccounts() {
        def accounts = request.JSON.accounts
        println(Accounts.list().size())
        accounts.each { account ->
            def newAccount = new Accounts()
            newAccount.name = account.firstName + " " + account.lastName
            newAccount.number = account.number

            newAccount.save()

        }

        def responseData = [status:200, message:"added new accounts"]

//        render(contentType: "application/json") {
//            responseData
//        }
        respond (status:200, accounts:accounts)
    }

    def editAccount() {
        def account = request.JSON.account
        def newAccount = Accounts.findByNumber(account.number.toInteger())

//        newAccount.name = account.name - don't change name
//        newAccount.number = account.number - don't change number
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

        respond([status:200, message:"updated account: " + newAccount.name])
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
        }

        def tanks = accounts.tanks

        respond([status:200, tanks:tanks, accounts:accounts.number])
    }
}