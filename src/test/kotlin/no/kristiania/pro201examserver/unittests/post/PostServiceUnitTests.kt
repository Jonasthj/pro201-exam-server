package no.kristiania.pro201examserver.unittests.post

import io.mockk.every
import io.mockk.mockk
import no.kristiania.pro201examserver.model.post.PostsEntity
import no.kristiania.pro201examserver.model.post.PostsInfoEntity
import no.kristiania.pro201examserver.repo.post.PostInfoRepo
import no.kristiania.pro201examserver.repo.post.PostRepo
import no.kristiania.pro201examserver.services.PostService
import org.junit.jupiter.api.Test

class PostServiceUnitTests {

    private val postRepo = mockk<PostRepo>()
    private val postInfoRepo = mockk<PostInfoRepo>()
    private val postService = PostService(postRepo, postInfoRepo)

    @Test
    fun shouldGetPosts(){

        val post1 = PostsEntity(id = 1, name = "Petter", latitude = 1F, longitude = 1F, quizId = 1, languageId = 1)
        val post2 = PostsEntity(id = 2, name = "Kjartan", latitude = 2F, longitude = 2F, quizId = 1, languageId = 1)

        every { postRepo.findAll() } answers {
            mutableListOf(post1, post2)
        }

        val posts = postService.getPosts()

        assert(posts != null)
        assert(posts?.size == 2)
        assert(posts?.first { it.id == post1.id }?.name == post1.name)
        assert(posts?.first { it.id == post2.id }?.name == post2.name)
    }

    @Test
    fun shouldGetPostInfos(){
        val postInfo1 = PostsInfoEntity(id = 1, infoHeader = "header1", postId = 1, infoImgId = 1)
        val postInfo2 = PostsInfoEntity(id = 2, infoHeader = "header2", postId = 1, infoImgId = 1)

        every { postInfoRepo.findAll() } answers {
            mutableListOf(postInfo1, postInfo2)
        }

        val postInfos = postService.getPostInfos()

        assert(postInfos != null)
        assert(postInfos?.size == 2)
        assert(postInfos?.first { it.id == postInfo1.id }?.infoHeader == postInfo1.infoHeader)
        assert(postInfos?.first { it.id == postInfo2.id }?.infoHeader == postInfo2.infoHeader)
    }
}