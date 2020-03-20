import services.*
import kotlin.system.exitProcess
import ExitCodes.*

class Handler(args: Array<String>) {
    var login = ""
        private set
    var password = ""
        private set
    var role = ""
        private set
    var resource = ""
        private set
    var dateStart = ""
        private set
    var dateEnd = ""
        private set
    var volume = ""
        private set

    init {
        if (args.isEmpty()) {
            printHelp()
            exitProcess(HelpCode.code)
        }
        if (args[0] == "-h") {
            printHelp()
            exitProcess(HelpCode.code)
        }
        if (args.size != 4 || args.size != 6 || args.size != 8) {
            printHelp()
            //Нужен ли exitProcess code?
        }
        if (args[0] != "-h" || args[0] != "-login") {
            printHelp()
            exitProcess(SuccessCode.code)
        }
        if (!args.contains("-h") || !args.contains("-login")) {
            printHelp()
            exitProcess(HelpCode.code)
        }
        for (arg in args) {
            when (arg) {
                "-login" -> if (args.indexOf(arg) != args.size) {
                    login = args[args.indexOf(arg) + 1]
                }
                "-pass" -> if (args.indexOf(arg) != args.size) {
                    password = args[args.indexOf(arg) + 1]
                }
                "-role" -> if (args.indexOf(arg) != args.size) {
                    role = args[args.indexOf(arg) + 1]
                }
                "-res" -> if (args.indexOf(arg) != args.size) {
                    resource = args[args.indexOf(arg) + 1]
                }
                "-ds" -> if (args.indexOf(arg) != args.size) {
                    dateStart = args[args.indexOf(arg) + 1]
                }
                "-de" -> if (args.indexOf(arg) != args.size) {
                    dateEnd = args[args.indexOf(arg) + 1]
                }
                "-vol" -> if (args.indexOf(arg) != args.size) {
                    volume = args[args.indexOf(arg) + 1]
                }
            }
            if (role != "" && !(role == "WRITE" || role == "READ" || role == "DELETE")) {
                exitProcess(UnknownRole.code)
            }
        }
    }

    fun authenNeeded(): Boolean {
        return login != "" && password != ""
    }

    fun authorizeNeeded(): Boolean {
        return authenNeeded() && resource != "" && password != ""
    }

    fun accountingNeeded(): Boolean {
        return authorizeNeeded() && dateEnd != "" && dateStart != "" && volume != ""
    }
}