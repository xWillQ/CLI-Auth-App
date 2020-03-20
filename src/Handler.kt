import services.*
import kotlin.system.exitProcess
import ExitCodes.*

class Handler(args: Array<String>) {
    private val parsedArgs = args
    var username = ""
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
        if (parsedArgs.isEmpty()) {
            printHelp()
            exitProcess(HelpCode.code)
        }
        if (parsedArgs[0] == "-h") {
            printHelp()
            exitProcess(HelpCode.code)
        }
        if (parsedArgs.size != 4 || parsedArgs.size != 6 || parsedArgs.size != 8) {
            printHelp()
            //Нужен ли exitProcess?
        }
        if (parsedArgs[0] != "-h" || parsedArgs[0] != "-login") {
            printHelp()
            exitProcess(SuccessCode.code)
        }
        if (!parsedArgs.contains("-h") || !parsedArgs.contains("-login")) {
            printHelp()
            exitProcess(HelpCode.code)
        }
        for (arg in parsedArgs) {
            when (arg) {
                "-login" -> if (args.indexOf(arg) != args.size) {
                    username = args[args.indexOf(arg) + 1]
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
        }
    }

    fun authenNeeded(): Boolean {
        return username != "" && password != ""
    }
    fun authorizeNeeded(): Boolean {
        return authenNeeded() && resource != "" && password != ""
    }
    fun roleExist(): Boolean {
        return role == "WRITE" || role == "READ" || role == "DELETE"
    }
}