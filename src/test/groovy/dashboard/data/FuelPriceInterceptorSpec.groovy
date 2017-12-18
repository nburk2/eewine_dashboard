package dashboard.data


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(FuelPriceInterceptor)
class FuelPriceInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test fuelPrice interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"fuelPrice")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
