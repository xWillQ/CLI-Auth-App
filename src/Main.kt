import Handler
import InitObjects.*
import models.User
import models.Session
import models.Resource
import services.AuthenticationService
import services.AuthorizeService
import services.HelpService
import ExitCodes.*
import kotlin.system.exitProcess


fun main(args: Array<String>) {
    val users = initUsers()
    val recources = initResources()
    val Handler = Handler(args)
    val help = HelpService()
    val authenService = AuthenService(users, recources)
    if (Handler.authenNeeded()) {
        login = Handler.getLogin()
        password = Handler.getPassword()
        authenService.authentication(login, password)
    } else {
        help.printHelp()
        exitProcess(SuccessCode.code)
    }
}

