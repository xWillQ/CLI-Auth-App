package services

import models.User
import models.Resource

class AuthenticationService(val users: List<User>, val resource: List<Resource>) {
    fun authentication(login: String, password: String) {

    }
    fun CheckLoginValidity(login: String): Boolean = login.matches(Regex("[a-z]{1,10}"))
    fun CheckLoginPresenceInBase(login: String, users: List<User>): User? = users.find {it.login == login}


    }


}