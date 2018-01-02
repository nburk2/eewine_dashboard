package dashboard.data

import com.bertramlabs.plugins.SSLRequired
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Secured(["ROLE_ADMIN"])
@SSLRequired
@Transactional(readOnly = true)
class FuelPriceController {

    def fuelPriceService

    def fuelPrices() {
        def fuelPrices = []
        def dtnPrices = []
        Date priceDate = new Date()
        if(params.priceDate && (FuelPrice.findByCreatedDate(params.getDate("priceDate")) == null)) {
            priceDate = params.getDate("priceDate")
            flash.info = "There is no stored data for this date"
            return [fuelPrices:fuelPrices, dtnPrices:dtnPrices, priceDate:priceDate ]
        }

        if(params.priceDate) {
            priceDate = params.getDate("priceDate")
            fuelPrices = fuelPriceService.getFuelPricesByDate(priceDate)
            dtnPrices = fuelPriceService.getDtnPricesByDate(priceDate)
        } else {
            fuelPrices = fuelPriceService.getFuelPrices()
            dtnPrices = fuelPriceService.getDtnPrices()
        }
        [fuelPrices:fuelPrices, dtnPrices:dtnPrices, priceDate:priceDate]
    }

    @Secured(["permitAll"])
    def printFuelPrices() {
        def date = null
        if(params.priceDate) {
            date = params.getDate("priceDate")
        }
        fuelPriceService.createFuelPriceExcel(date)
        File file1 = new File("fuelPrices.xlsx")
        fuelPriceService.uploadS3FileToPrint(file1)
        file1.delete()

        fuelPriceService.createDtnPriceExcel(date)
        File file2 = new File("dtnPrices.xlsx")
        fuelPriceService.uploadS3FileToPrint(file2)
        file2.delete()
        flash.info = "Prints every half hour on the hour"
        redirect(action:"fuelPrices")
    }

    @Secured(["permitAll"])
    def addFuelPrices() {
        // Request will come from api gateway with api key that is checked in the interceptor
        fuelPriceService.addTodaysFuelPrices()
        fuelPriceService.addTodaysDtnPrices()
        def response = [status:200, creation:"success"]
        render response as JSON
    }
}
