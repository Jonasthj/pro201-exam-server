package no.kristiania.pro201examserver.repo.minigame

import no.kristiania.pro201examserver.model.minigame.MinigameEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MinigameRepo : JpaRepository<MinigameEntity, Long>