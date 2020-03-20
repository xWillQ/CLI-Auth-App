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
    }
}