import Handler
import InitObjects.*
import ExitCodes.*
import models.*
import services.*
import kotlin.system.exitProcess


fun main(args: Array<String>) {
    val users = initUsers()
    val user: User?
    val AuthorizeSuccess: Boolean?
    val recources = initResources()
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
    val authorizeService = AuthorizationService(recources)
    if (handler.authorizeNeeded()) {
        val role = handler.getRole()
        val resourceName = handler.getResource()
        AuthorizeSuccess = authorizeService.authorization(user, role, resourceName)
    } else {
        help.printHelp()
        exitProcess(SuccessCode.code)

    }
    if (!AuthorizeSuccess) {
        exitProcess(NoAccess.code)
    }
    val accountService = AccountingService()
    if (Handler.accountingNeeded()) {
        accountService.accounting()

    }
}

