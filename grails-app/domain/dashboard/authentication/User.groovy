package dashboard.authentication


import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic
import grails.plugin.springsecurity.SpringSecurityService

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1
    SpringSecurityService springSecurityService

    String username
    String password
    boolean enabled = true
    String email
    String firstName
    String lastName
    boolean accountExpired = false
    boolean accountLocked = false
    boolean passwordExpired = false

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static transients = ['springSecurityService']

    static constraints = {
        password blank: false, password: true
        username blank: false, unique: true
        firstName nullable: true
        lastName nullable: true
        email nullable: true
    }

    static mapping = {
        password column: '`password`'
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }

    String toString(){
        username
    }
}