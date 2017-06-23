package dashboard.data

import grails.rest.Resource

class Winotstop {

    String name
    String value

    static constraints = {
        name nullable: false, unique: true, matches: "^[a-zA-Z-]*"
        value nullable: false
    }
}
