package no.kristiania.pro201examserver.services

import no.kristiania.pro201examserver.repo.SessionRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SessionService(
    @Autowired private val playerService: PlayerService,
    @Autowired private val minigameScoresService: MinigameScoresService,
    @Autowired private val sessionRepo: SessionRepo
) {

    fun clearSession(sessionId: String): Boolean {
        val players = playerService.findAllPlayers(sessionId)

        if(players != null && players.isNotEmpty()) {
            players.forEach{ player ->
                minigameScoresService.deleteScores(player.id)
                playerService.deleteById(player.id)
            }
            sessionRepo.deleteById(sessionId)
            return true
        }
        return false
    }

}