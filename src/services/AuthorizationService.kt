package services

import models.*

class AuthorizationService(val recources: List<Resource>) {
    fun authorization(user: User, role: String, resourceName: String): Boolean {
        val login = GetLogin(user)
        val rights = GetAccessResources(login, recources)
        val accessResult = CheckAccess(recources, resourceName)
        val access = accessResult.first
        val roles = SetAccess(accessResult.second).distinct()
        if (access && role in roles) {
            return true
        } else {
            return false
        }

    }

    fun GetLogin(user: User): String = user.login
    fun GetResName(resource: Resource): String = resource.resource
    fun GetResRole(resource: Resource): String = resource.role
    fun GetAccessResources(login: String, recources: List<Resource>): List<Resource> =
        recources.filter { it.login == login }

    fun CheckAccess(resources: List<Resource>, needResourceName: String): Pair<Boolean, MutableList<String>> {
        var access = false
        val roles = mutableListOf<String>()
        for (resource in recources) {
            val resourceName = GetResName(resource)
            if (needResourceName.startsWith(resourceName) || needResourceName == resourceName) {
                access = true
                val role = GetResRole(resource)
                roles.add(role)
            }
        }
        return Pair(access, roles)
    }

    fun SetAccess(roles: MutableList<String>): MutableList<String> {
        when {
            ("EXECUTE" in roles && "WRITE" !in roles) -> roles.add("WRITE")
            ("EXECUTE" in roles && "READ" !in roles) -> roles.add("READ")
            ("WRITE" in roles && "READ" !in roles) -> roles.add("READ")
        }
        return roles
    }


}
