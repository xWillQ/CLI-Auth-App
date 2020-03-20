import services.*
import kotlin.system.exitProcess
import ExitCodes.*

class Handler(args: Array<String>) {
    init {
        if (args.isEmpty()) {
            printHelp()
            exitProcess(HelpCode.code)
        }
        if (args[0] == "-h") {
            printHelp()
            exitProcess(HelpCode.code)
        }
        if (args.size != 4 || args.size !=6 || args.size !=8) {
            printHelp()
            //Нужен ли exitProcess?
        }
    }
}