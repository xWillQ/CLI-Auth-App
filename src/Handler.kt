import services.*
import kotlin.system.exitProcess
import ExitCodes.*

class Handler(args: Array<String>) {
    val parsedArgs = args

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
            //Нужен ли exitProcess?
        }
        if (args[0] != "-h" || args[0] != "-login") {
            printHelp()
            exitProcess(SuccessCode.code)
        }
        if (!args.contains("-h") || !args.contains("-login")) {
            printHelp()
            exitProcess(HelpCode.code)
        }
    }

    public fun authenNeeded(): Boolean {
        return parsedArgs.contains("-login") && parsedArgs.contains("-pass")
    }
}