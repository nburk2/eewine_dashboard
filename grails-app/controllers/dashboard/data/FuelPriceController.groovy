package dashboard.data

import com.bertramlabs.plugins.SSLRequired
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Secured(["ROLE_ADMIN"])
@SSLRequired
@Transactional(readOnly = true)
class FuelPriceController {

    def fuelPriceService

    def fuelPrices() {
        def fuelPrices = fuelPriceService.getFuelPrices()
        def dtnPrices = fuelPriceService.getDtnPrices()
        [fuelPrices:fuelPrices, dtnPrices:dtnPrices]
    }

    @Secured(["permitAll"])
    def printFuelPrices() {
        fuelPriceService.createFuelPriceExcel()
        File file1 = new File("fuelPrices.xlsx")
        fuelPriceService.uploadS3FileToPrint(file1)
        file1.delete()

        fuelPriceService.createDtnPriceExcel()
        File file2 = new File("dtnPrices.xlsx")
        fuelPriceService.uploadS3FileToPrint(file2)
        file2.delete()
    }


}
