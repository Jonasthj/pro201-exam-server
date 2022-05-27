package no.kristiania.pro201examserver.repo.post

import no.kristiania.pro201examserver.model.post.PostsEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepo: JpaRepository<PostsEntity, Long> {
}