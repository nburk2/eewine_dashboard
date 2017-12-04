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
        [fuelPrices:fuelPrices]
    }

    @Secured(["permitAll"])
    def printFuelPrices() {
        fuelPriceService.createFuelPriceExcel()
        File file = new File("fuelPrices.xlsx")
        fuelPriceService.uploadS3FileToPrint(file)
        file.delete()
    }


}
