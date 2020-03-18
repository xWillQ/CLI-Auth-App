package services

import ExitCodes.*
import java.math.BigInteger
import java.security.MessageDigest
import models.User
import models.Resource
import kotlin.system.exitProcess

class AuthenticationService(val users: List<User>, val resource: List<Resource>) {
    fun authentication(login: String, password: String): User {
        if (!CheckLoginValidity(login)) {
            exitProcess(InvalidLoginFormat.code)
        }
        if (CheckLoginPresenceInBase(login, users) == null) {
            exitProcess(UnknownLogin.code)
        }
        val nowHash = GetPasswordHash(password)
        val user = GetUser(login, users)
        val baseHash = GetPasswordHashInBase(user)
        if (!CheckPasswordsHashs(baseHash, nowHash)) {
            exitProcess(InvalidPassword.code)
        }

        return user
    }

    fun CheckLoginValidity(login: String): Boolean = login.matches(Regex("[a-z]{1,10}"))
    fun CheckLoginPresenceInBase(login: String, users: List<User>): User? = users.find { it.login == login }
    fun GetUser(login: String, users: List<User>): User = users.first { it.login == login }
    fun GetPasswordHash(password: String): String = password.md5()
    fun GetPasswordHashInBase(user: User): String = user.hash
    fun CheckPasswordsHashs(baseHash: String, nowHash: String): Boolean = baseHash == nowHash


    fun String.md5(): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }
}


}