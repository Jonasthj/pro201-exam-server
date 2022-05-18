package no.kristiania.pro201examserver.repo

import no.kristiania.pro201examserver.model.MinigameEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface MinigamesRepo : JpaRepository<MinigameEntity, Long>
