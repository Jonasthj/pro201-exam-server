package no.kristiania.pro201examserver.repo.minigame

import no.kristiania.pro201examserver.model.minigame.MinigameEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MinigameRepo : JpaRepository<MinigameEntity, Long>