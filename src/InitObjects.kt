package InitObjects

import models.User
import models.Resource

fun initUsers() = listOf(
    User(
        login = "admin",
        hash = "21232f297a57a5a743894a0e4a801fc3" //admin
    ),
    User(
        login = "petr",
        hash = "5685dc8ca490fb3399ed2ddeb5faddca" //petr101
    ),
    User(
        login = "vasya",
        hash = "202cb962ac59075b964b07152d234b70" //123
    ),
    User(
        login = "q",
        hash = "3a4d92a1200aad406ac50377c7d863aa" //!@#$
    )
)


fun initResources() = listOf(
    Resource(
        resource = "A",
        login = "vasya",
        role = "READ"
    ),
    Resource(
        resource = "A.B",
        login = "admin",
        role = "EXECUTE"
    ),
    Resource(
        resource = "A.B.C",
        login = "petr",
        role = "WRITE"
    ),
    Resource(
        resource = "A.B.D",
        login = "q",
        role = "READ"
    ),
    Resource(
        resource = "A.BB",
        login = "petr",
        role = "EXECUTE"
    ),
    Resource(
        resource = "AB",
        login = "admin",
        role = "WRITE"
    ),
    Resource(
        resource = "A",
        login = "admin",
        role = "READ"
    )
)


