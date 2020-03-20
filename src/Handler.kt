import services.helpMessage
import kotlin.system.exitProcess
import ExitCodes.*

class Handler(args: Array<String>) {
    init {
        if (args.isEmpty()) {
            print(helpMessage)
            exitProcess(HelpCode.code)
        }
    }
}