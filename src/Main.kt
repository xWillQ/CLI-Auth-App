import InitObjects.*
import ExitCodes.*
import services.*
import kotlin.system.exitProcess


fun main(args: Array<String>) {
    val users = initUsers()
    val resources = initResources()
    val handler = Handler(args)
    val authService = AuthenticationService(users)
    val authorizeService = AuthorizationService(resources)
    val accountService = AccountingService()
    if (!handler.authenNeeded()) {
        terminate(true, HelpCode.code)
    } else {
        val user = authService.authentication(handler.login, handler.password)
        if (!handler.authorizeNeeded()) {
            terminate(true, HelpCode.code)
        } else {
            val haveAccess = authorizeService.authorization(user, handler.role, handler.resource)
            when {
                (!haveAccess) -> terminate(false, NoAccess.code)
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
