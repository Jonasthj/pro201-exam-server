package no.kristiania.pro201examserver.repo.player

import no.kristiania.pro201examserver.model.player.PlayerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepo : JpaRepository<PlayerEntity, Long> {
    fun findAllBySessionId(sessionId: String): List<PlayerEntity>?
}