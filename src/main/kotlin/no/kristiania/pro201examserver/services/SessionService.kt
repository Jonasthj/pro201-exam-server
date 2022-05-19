package no.kristiania.pro201examserver.services

import no.kristiania.pro201examserver.model.SessionEntity
import no.kristiania.pro201examserver.repo.SessionRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SessionService(
    @Autowired private val sessionRepo: SessionRepo
) {

    fun clearSession(sessionId: String): Boolean {
        sessionRepo.deleteById(sessionId)

        return true
    }

    fun saveSession(session: SessionEntity) : SessionEntity {
        return sessionRepo.save(session)
    }

}