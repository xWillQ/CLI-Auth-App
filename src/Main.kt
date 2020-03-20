import InitObjects.*
import ExitCodes.*
import models.*
import services.*
import kotlin.system.exitProcess


fun main(args: Array<String>) {
    val users = initUsers()
    val user: User?
    val AuthorizeSuccess: Boolean?import InitObjects.*
import ExitCodes.*
import models.*
import services.*
import kotlin.system.exitProcess


fun main(args: Array<String>) {
    val users = initUsers()
    val recources = initResources()
    val handler = Handler(args)
    val authenService = AuthenticationService(users, recources)
    val authorizeService = AuthorizationService(recources)
    val accountService = AccountingService()
    if (!handler.authenNeeded()) {
        terminate(true, HelpCode.code)
    } else {
        val user = authenService.authentication(handler.login, handler.password)
        if (!handler.authorizeNeeded()) {
            terminate(true, HelpCode.code)
        } else {
            val HaveAcces = authorizeService.authorization(user, handler.role, handler.resource)
            when {
                (!HaveAcces) -> terminate(false, NoAccess.code)
                (Handler.accountingNeeded()) -> accountService.accounting()
                else -> terminate(false, SuccessCode.code)
            }
        }
    }
}

fun terminate(printHelp: Boolean, errorCode: Int) {
    if (printHelp) {
        printHelp()
    }
    exitProcess(errorCode)
}

   
