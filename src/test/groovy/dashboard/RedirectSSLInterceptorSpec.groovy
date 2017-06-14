package dashboard


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(RedirectSSLInterceptor)
class RedirectSSLInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test redirectSSL interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"redirectSSL")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
