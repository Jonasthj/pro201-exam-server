package no.kristiania.pro201examserver.unittests.post

import io.mockk.every
import io.mockk.mockk
import no.kristiania.pro201examserver.model.post.PostsEntity
import no.kristiania.pro201examserver.model.post.PostsInfoEntity
import no.kristiania.pro201examserver.services.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@ExtendWith(SpringExtension::class)
@WebMvcTest
@AutoConfigureMockMvc(addFilters = false)
class PostControllerUnitTests {

    @TestConfiguration
    class ControllerTestConfig {
        @Bean
        fun minigameService() = mockk<MinigameService>()
        @Bean
        fun playerService() = mockk<PlayerService>()
        @Bean
        fun sessionService() = mockk<SessionService>()
        @Bean
        fun quizService() = mockk<QuizService>()
        @Bean
        fun languageService() = mockk<LanguageService>()
        @Bean
        fun postService() = mockk<PostService>()
    }

    @Autowired
    private lateinit var postService: PostService

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun shouldGetPosts(){

        val post1 = PostsEntity(id = 1, name = "Petter", latitude = 1F, longitude = 1F, quizId = 1, languageId = 1)
        val post2 = PostsEntity(id = 2, name = "Kjartan", latitude = 2F, longitude = 2F, quizId = 1, languageId = 1)

        every { postService.getPosts() } answers {
            mutableListOf(post1, post2)
        }

        mockMvc.get("/api/post/all")
            .andExpect { status { isOk() } }
            .andExpect { content { contentType(MediaType.APPLICATION_JSON) } }
            .andReturn()
    }

    @Test
    fun shouldGetPostInfos(){
        val postInfo1 = PostsInfoEntity(id = 1, infoHeader = "header1", postId = 1, infoImgId = 1)
        val postInfo2 = PostsInfoEntity(id = 2, infoHeader = "header2", postId = 1, infoImgId = 1)

        every { postService.getPostInfos() } answers {
            mutableListOf(postInfo1, postInfo2)
        }

        mockMvc.get("/api/post/info/all")
            .andExpect { status { isOk() } }
            .andExpect { content { contentType(MediaType.APPLICATION_JSON) } }
            .andReturn()
    }
}