package no.kristiania.pro201examserver.services

import no.kristiania.pro201examserver.model.player.PlayerEntity
import no.kristiania.pro201examserver.model.player.SessionEntity
import no.kristiania.pro201examserver.model.quiz.PlayerAnswerEntity
import no.kristiania.pro201examserver.repo.quiz.PlayerAnswerRepo
import no.kristiania.pro201examserver.repo.player.PlayerRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlayerService(
    @Autowired private val playerRepo: PlayerRepo,
    @Autowired private val sessionService: SessionService,
    @Autowired private val minigameScoresService: MinigameService,
    @Autowired private val playerAnswerRepo: PlayerAnswerRepo
) {

    fun findAllPlayers(sessionId: String): List<PlayerEntity>? {
        return playerRepo.findAllBySessionId(sessionId)
    }

    fun deleteById(id: Long?) {
        id?.let { playerRepo.deleteById(it) }
    }

    fun savePlayer(playerInfo: PlayerInfo): PlayerEntity {
        val player =
            PlayerEntity(
                id = playerInfo.id,
                name = playerInfo.name,
                avatarIndex = playerInfo.avatarIndex,
                sessionId = playerInfo.sessionId)

        playerInfo.sessionId?.let {
            sessionService.saveSession(SessionEntity(it))
        }

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

    fun getPlayerAnswers(sessionId: String): List<PlayerAnswerEntity> {
        val players = findAllPlayers(sessionId)
        var resultList = listOf<PlayerAnswerEntity>()

        if (players != null && players.isNotEmpty()) {
            players.forEach{ player ->
                player.id?.let {
                    val playerAnswer = playerAnswerRepo.findPlayerAnswerEntitiesByPlayerId(it)
                    if (playerAnswer != null) {
                        resultList += playerAnswer
                    }
                }
            }
        }
        return resultList
    }

}

data class PlayerInfo(
    val id: Long?, val name: String?, val avatarIndex: Int?, val sessionId: String?
)
