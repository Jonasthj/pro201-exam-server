package no.kristiania.pro201examserver.services

import no.kristiania.pro201examserver.model.MinigameScoresEntity
import no.kristiania.pro201examserver.repo.MinigameScoresRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MinigameScoresService(@Autowired private val minigamesScoresRepo: MinigameScoresRepo) {

    fun saveScore(scoresInfo: ScoresInfo): MinigameScoresEntity {
        val entity = MinigameScoresEntity(amount = scoresInfo.amount, time = scoresInfo.time, playerId = scoresInfo.playerId)
        return minigamesScoresRepo.save(entity)
    }

}

data class ScoresInfo(val amount: Int, val time: Float, val playerId: Long)