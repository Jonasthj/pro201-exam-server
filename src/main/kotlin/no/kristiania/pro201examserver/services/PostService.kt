package no.kristiania.pro201examserver.services

import no.kristiania.pro201examserver.model.post.PostsEntity
import no.kristiania.pro201examserver.model.post.PostsInfoEntity
import no.kristiania.pro201examserver.repo.post.PostInfoRepo
import no.kristiania.pro201examserver.repo.post.PostRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService(
    @Autowired private val postRepo: PostRepo,
    @Autowired private val postInfoRepo: PostInfoRepo) {

    fun getPosts(): List<PostsEntity>? {
        return postRepo.findAll()
    }

    fun getPostInfo(postId: Long): PostsInfoEntity? {
        return postInfoRepo.getByPostId(postId)
    }

    fun getPostInfos(): List<PostsInfoEntity>? {
        return postInfoRepo.findAll()
    }
}