package no.kristiania.pro201examserver.repo.quiz

import no.kristiania.pro201examserver.model.quiz.PlayerAnswerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PlayerAnswerRepo : JpaRepository<PlayerAnswerEntity, Long> {
    fun findAllByPlayerId(playerId: Long) : List<PlayerAnswerEntity>?

    fun getByPlayerIdAndAndAnswerId(playerId: Long, answerId: Long): PlayerAnswerEntity?
}