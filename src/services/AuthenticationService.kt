package services

import java.math.BigInteger
import java.security.MessageDigest
import models.User
import models.Resource

class AuthenticationService(val users: List<User>, val resource: List<Resource>) {
    fun authentication(login: String, password: String) {

    }

    fun CheckLoginValidity(login: String): Boolean = login.matches(Regex("[a-z]{1,10}"))
    fun CheckLoginPresenceInBase(login: String, users: List<User>): User? = users.find { it.login == login }
    fun GetPasswordHash(password: String): String = password.md5()

    fun String.md5(): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }
}


}