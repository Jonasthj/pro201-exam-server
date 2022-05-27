package no.kristiania.pro201examserver.repo.post

import no.kristiania.pro201examserver.model.post.PostsInfoEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostInfoRepo: JpaRepository<PostsInfoEntity, Long> {

    fun getByPostId(postId: Long): PostsInfoEntity?

}