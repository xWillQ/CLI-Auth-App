package collections

import models.User
import models.Resource
import models.Session

var users = mutableListOf<User>(
        User(login = "admin", hash = "21232f297a57a5a743894a0e4a801fc3"),
        User(login = "petr", hash = "5685dc8ca490fb3399ed2ddeb5faddca"),
        User(login = "vasya", hash = "202cb962ac59075b964b07152d234b70"),
        User(login = "q", hash = "3a4d92a1200aad406ac50377c7d863aa")
)
    private set


var resources = mutableListOf(
        Resource(resource = "A", login = "vasya", role = "READ"),
        Resource(resource = "A.B", login = "admin", role = "EXECUTE"),
        Resource(resource = "A.B.C", login = "petr", role = "WRITE"),
        Resource(resource = "A.B.D", login = "q", role = "READ"),
        Resource(resource = "A.BB", login = "petr", role = "EXECUTE"),
        Resource(resource = "AB", login = "admin", role = "WRITE"),
        Resource(resource = "A", login = "admin", role = "READ")
)
    private set

var sessions: MutableList<Session> = mutableListOf()

fun addSession(session: Session) {
    sessions.add(session)
}