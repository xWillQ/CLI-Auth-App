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
    val authenService = AuthenticationService(users, recources)
    if (handler.authenNeeded()) {
        user = authenService.authentication(handler.login, handler.password)

    } else {
        printHelp()
        exitProcess(SuccessCode.code)
    }
    val authorizeService = AuthorizationService(recources)
    if (handler.authorizeNeeded()) {
        AuthorizeSuccess = authorizeService.authorization(user, handler.role, handler.resource)
    } else {
        printHelp()
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

