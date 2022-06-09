package no.kristiania.pro201examserver.repo.post

import no.kristiania.pro201examserver.model.post.PostsInfoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostInfoRepo: JpaRepository<PostsInfoEntity, Long> {

    fun getByPostId(postId: Long): PostsInfoEntity?

}