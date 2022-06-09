package no.kristiania.pro201examserver.repo.quiz

import no.kristiania.pro201examserver.model.quiz.PlayerAnswerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional


@Repository
interface PlayerAnswerRepo : JpaRepository<PlayerAnswerEntity, Long> {
    fun findAllByPlayerId(playerId: Long) : List<PlayerAnswerEntity>?

    fun getByPlayerIdAndAndQuestionId(playerId: Long, questionId: Long): PlayerAnswerEntity?

    @Transactional
    fun deleteAllByPlayerId(playerId: Long?)
}