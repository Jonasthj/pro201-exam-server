package no.kristiania.pro201examserver.repo.minigame

import no.kristiania.pro201examserver.model.minigame.MinigameRoundsEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MinigameRoundsRepo: JpaRepository<MinigameRoundsEntity, Long> {
    fun getAllByPostId(postId: Long): List<MinigameRoundsEntity>?
}