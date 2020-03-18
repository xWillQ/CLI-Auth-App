package services

import models.User
import models.Resource

class AuthenticationService(val users: List<User>, val resource: List<Resource>) {
    fun authentication(login: String, password: String) {

    }
}