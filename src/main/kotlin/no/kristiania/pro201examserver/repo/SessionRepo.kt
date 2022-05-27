package no.kristiania.pro201examserver.repo

import no.kristiania.pro201examserver.model.player.SessionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SessionRepo : JpaRepository<SessionEntity, String>