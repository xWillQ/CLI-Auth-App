package services

import ExitCodes.*
import java.math.BigInteger
import java.security.MessageDigest
import models.User
import kotlin.system.exitProcess

class AuthenticationService(private val users: List<User>) {
    fun authentication(login: String, password: String): User {
        if (!checkLoginValidity(login)) {
            exitProcess(InvalidLoginFormat.code)
        }
        if (checkLoginPresenceInBase(login, users) == null) {
            exitProcess(UnknownLogin.code)
        }
        val nowHash = getPasswordHash(password)
        val user = getUser(login, users)
        val baseHash = getPasswordHashInBase(user)
        if (!checkPasswordsHashs(baseHash, nowHash)) {
            exitProcess(InvalidPassword.code)
        }

        return user
    }

    private fun checkLoginValidity(login: String): Boolean = login.matches(Regex("[a-z]{1,10}"))
    private fun checkLoginPresenceInBase(login: String, users: List<User>): User? = users.find { it.login == login }
    private fun getUser(login: String, users: List<User>): User = users.first { it.login == login }
    private fun getPasswordHash(password: String): String = password.md5()
    private fun getPasswordHashInBase(user: User): String = user.hash
    private fun checkPasswordsHashs(baseHash: String, nowHash: String): Boolean = baseHash == nowHash


    private fun String.md5(): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }
}


