package services

import models.*

class AuthorizationService(private val resources: List<Resource>) {
    fun authorization(user: User, role: String, resourceName: String): Boolean {
        val login = getLogin(user)
        val rights = getAccessResources(login, resources)
        val accessResult = checkAccess(rights, resourceName)
        val access = accessResult.first
        val roles = accessResult.second.distinct()
        return (access && role in roles)


    }

    private fun getLogin(user: User): String = user.login
    private fun getResourceName(resource: Resource): String = resource.resource
    private fun gerResourceRole(resource: Resource): String = resource.role
    private fun getAccessResources(login: String, resources: List<Resource>): List<Resource> =
        resources.filter { it.login == login }

    private fun checkAccess(needResourceName: String, resourceName: String): Boolean =
        needResourceName.startsWith(resourceName) || needResourceName == resourceName

    private fun checkAccess(resources: List<Resource>, needResourceName: String): Pair<Boolean, MutableList<String>> {
        var access = false
        val roles = mutableListOf<String>()
        for (resource in resources) {
            val resourceName = getResourceName(resource)
            if (checkAccess(needResourceName, resourceName)) {
                access = true
                val role = gerResourceRole(resource)
                roles.add(role)
            }
        }
        return Pair(access, roles)
    }


}
