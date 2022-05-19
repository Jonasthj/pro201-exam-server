package no.kristiania.pro201examserver.services

import no.kristiania.pro201examserver.model.MinigameScoresEntity
import no.kristiania.pro201examserver.repo.MinigameScoresRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MinigameScoresService(@Autowired private val minigamesScoresRepo: MinigameScoresRepo) {

    fun saveScore(scoresInfo: ScoresInfo): MinigameScoresEntity? {

        if(scoresInfo.playerId != null && scoresInfo.minigameId != null) {
            val playerScore = minigamesScoresRepo.getByPlayerIdAndMinigameId(scoresInfo.playerId, scoresInfo.minigameId)

            val entity = MinigameScoresEntity(
                id = playerScore?.id,
                amount = scoresInfo.amount ?: playerScore?.amount,
                time = scoresInfo.time ?: playerScore?.time,
                playerId = scoresInfo.playerId,
                minigameId = scoresInfo.minigameId)

            return minigamesScoresRepo.save(entity)
        }

        return null
    }

    fun deleteScores(id: Long?) {
        id?.let {
            println(it)
            minigamesScoresRepo.deleteAllByPlayerId(it) }
    }

}

data class ScoresInfo(val id: Long?, val amount: Int?, val time: Float?, val playerId: Long?, val minigameId: Long?)