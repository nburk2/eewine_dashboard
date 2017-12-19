package dashboard.data

import grails.util.Holders


class FuelPriceInterceptor {

    def config = Holders.config
    def portalKey = config.PORTAL_KEY

    FuelPriceInterceptor() {
        match(controller:"fuelPrice",action:"addFuelPrices")
    }

    boolean before() {
        if(request.getHeader("portal-api-key") != portalKey) {
            return true
        }
        false
    }

    boolean after() {
        true
    }

    void afterView() {
        // no-op
    }
}
