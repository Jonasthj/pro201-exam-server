package no.kristiania.pro201examserver.services

import no.kristiania.pro201examserver.model.minigame.MinigameEntity
import no.kristiania.pro201examserver.model.minigame.MinigameRoundsEntity
import no.kristiania.pro201examserver.model.minigame.MinigameScoresEntity
import no.kristiania.pro201examserver.repo.minigame.MinigameRepo
import no.kristiania.pro201examserver.repo.minigame.MinigameRoundsRepo
import no.kristiania.pro201examserver.repo.minigame.MinigameScoresRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class MinigameService(
    @Autowired private val minigameRepo: MinigameRepo,
    @Autowired private val minigamesScoresRepo: MinigameScoresRepo,
    @Autowired private val minigameRoundsRepo: MinigameRoundsRepo
    ) {

    fun saveScore(scoresInfo: ScoresInfo): MinigameScoresEntity? {

        if(scoresInfo.playerId != null && scoresInfo.roundId != null) {
            val playerScore = minigamesScoresRepo.getByPlayerIdAndRoundId(scoresInfo.playerId, scoresInfo.roundId)

            val entity = MinigameScoresEntity(
                id = playerScore?.id,
                amount = scoresInfo.amount ?: playerScore?.amount,
                time = scoresInfo.time ?: playerScore?.time,
                playerId = scoresInfo.playerId,
                roundId = scoresInfo.roundId)

            return minigamesScoresRepo.save(entity)
        }

        return null
    }

    fun deleteScores(id: Long?) {
        id?.let {
            println(it)
            minigamesScoresRepo.deleteAllByPlayerId(it) }
    }

    fun getMinigames(): List<MinigameEntity>? {
        return minigameRepo.findAll()
    }

    fun getMinigameRounds(): List<MinigameRoundsEntity>? {
        return minigameRoundsRepo.findAll()
    }

    fun getMinigameRound(roundId: Long): MinigameRoundsEntity? {
        return minigameRoundsRepo.getById(roundId);
    }

}

data class ScoresInfo(val id: Long?, val amount: Int?, val time: Float?, val created: LocalDateTime?, val playerId: Long?, val roundId: Long?)