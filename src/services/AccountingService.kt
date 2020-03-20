package services

import models.*

class AccountingService {
    fun accounting(dateStart: String, dateEnd: String, volume: String, resource: String) {
        val session = Session(dateStart, dateEnd, volume, resource)
    }
}

