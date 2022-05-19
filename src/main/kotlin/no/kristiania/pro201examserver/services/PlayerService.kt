package no.kristiania.pro201examserver.services

import no.kristiania.pro201examserver.model.PlayerEntity
import no.kristiania.pro201examserver.model.SessionEntity
import no.kristiania.pro201examserver.repo.PlayerRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlayerService(
    @Autowired private val playerRepo: PlayerRepo,
    @Autowired private val sessionService: SessionService,
    @Autowired private val minigameScoresService: MinigameScoresService
) {

    fun findAllPlayers(sessionId: String): List<PlayerEntity>? {
        return playerRepo.findAllBySessionId(sessionId)
    }

    fun deleteById(id: Long?) {
        id?.let { playerRepo.deleteById(it) }
    }

    fun savePlayer(playerInfo: PlayerInfo): PlayerEntity {
        val player =
            PlayerEntity(name = playerInfo.name, avatarIndex = playerInfo.avatarIndex, sessionId = playerInfo.sessionId)

        playerInfo.sessionId?.let {
            println(sessionService.getSession(it).toString())

            /*if (sessionService.getSession(it).) {
                sessionService.saveSession(SessionEntity(it))
            }
*/        }

        return playerRepo.save(player)
    }

    fun deletePlayers(sessionId: String): Boolean {
        val players = findAllPlayers(sessionId)

        if (players != null && players.isNotEmpty()) {
            players.forEach { player ->
                minigameScoresService.deleteScores(player.id)
                deleteById(player.id)
            }
            return true
        }
        return false
    }

}

data class PlayerInfo(
    val name: String? = null, val avatarIndex: Int? = null, val sessionId: String? = null
)
