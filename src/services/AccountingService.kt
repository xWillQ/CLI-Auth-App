package services

import models.Session
import collections.addSession

class AccountingService {
    fun accounting(dateStart: String, dateEnd: String, volume: String, resource: String) {
        addSession(Session(dateStart, dateEnd, volume, resource))
    }
}
