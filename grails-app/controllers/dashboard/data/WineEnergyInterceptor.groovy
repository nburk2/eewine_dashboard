package dashboard.data

import grails.util.Holders


class WineEnergyInterceptor {

    def config = Holders.config
    def portalKey = config.PORTAL_KEY

    WineEnergyInterceptor() {
        match(controller:"wineEnergy",action:"getDataEntry")
    }

    boolean before() {
        if(request.getHeader("portal-api-key") == portalKey) {
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
