package no.kristiania.pro201examserver.services

import no.kristiania.pro201examserver.model.PlayerEntity
import no.kristiania.pro201examserver.repo.PlayerRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlayerService(
    @Autowired private val playerRepo: PlayerRepo
    ) {

    fun findAllPlayers(sessionId: String): List<PlayerEntity>? {
        return playerRepo.findAllBySessionId(sessionId)
    }

    fun deleteById(id: Long?) {
        id?.let { playerRepo.deleteById(it) }
    }

}
