package no.kristiania.pro201examserver.repo

import no.kristiania.pro201examserver.model.MinigameScoresEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface MinigameScoresRepo : JpaRepository<MinigameScoresEntity, Long>
