import Handler
import InitObjects.*
import models.User
import models.Session
import models.Resource
import services.AuthenticationService
import services.AuthorizeService
import services.HelpService
import ExitCodes.*
import javax.security.sasl.AuthorizeCallback
import kotlin.system.exitProcess


fun main(args: Array<String>) {
    val users = initUsers()
    val user: User?
    val resources = initResources()
    val handler = Handler(args)
    val help = HelpService()
    val authenService = AuthenticationService(users, recources)
    if (handler.authenNeeded()) {
        val login = handler.getLogin()
        val password = handler.getPassword()
        user = authenService.authentication(login, password)

    } else {
        help.printHelp()
        exitProcess(SuccessCode.code)
    }
    val authorizeService = AuthorizeService()
    if (handler.authorizeNeeded()) {
        val role = handler.getRole()
        val resource = handler.getResource()
        val AuthorizeSuccess = authorizeService.authorization(user, role, resource)
    } else {
        help.printHelp()
        exitProcess(SuccessCode.code)
    }
}

