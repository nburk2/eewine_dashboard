package dashboard


class RedirectSSLInterceptor {

    boolean before() {
        if (!request.isSecure() && !Environment.isDevelopmentMode()) {
            def url = "https://" + request.serverName + request.forwardURI
            redirect(url: url, permanent: true)
            return false
        }
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
