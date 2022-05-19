package no.kristiania.pro201examserver.repo

import no.kristiania.pro201examserver.model.MinigameScoresEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional


@Repository
interface MinigameScoresRepo : JpaRepository<MinigameScoresEntity, Long> {
    fun getByPlayerIdAndMinigameId(playerId: Long, minigameId: Long): MinigameScoresEntity?

    @Transactional
    fun deleteAllByPlayerId(playerId: Long)
}
