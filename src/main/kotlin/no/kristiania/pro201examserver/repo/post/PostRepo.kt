package no.kristiania.pro201examserver.repo.post

import no.kristiania.pro201examserver.model.post.PostsEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepo: JpaRepository<PostsEntity, Long> {
}