package no.kristiania.pro201examserver.repo

import no.kristiania.pro201examserver.model.PlayerAnswerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PlayerAnswerRepo : JpaRepository<PlayerAnswerEntity, Long> {
    fun findPlayerAnswerEntitiesByPlayerId(playerId: Long) : PlayerAnswerEntity?
}