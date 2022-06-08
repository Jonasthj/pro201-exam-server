package no.kristiania.pro201examserver.unittests.minigame

import io.mockk.every
import io.mockk.mockk
import no.kristiania.pro201examserver.model.quiz.QuizEntity
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
class MinigameControllerUnitTests {

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
    private lateinit var quizService: QuizService

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun shouldGetQuiz(){

        val quizId: Long = 1
        val quiz = QuizEntity(id = 1, 1, mutableListOf())

        every { quizService.getQuiz(quizId) } answers {
            quiz
        }

        mockMvc.get("/api/quiz?quizId=${quizId}")
            .andExpect { status { isOk() } }
            .andExpect { content { contentType(MediaType.APPLICATION_JSON) } }
            .andReturn()
    }

    @Test
    fun shouldGetQuizzes(){
        
        val quiz1 = QuizEntity(id = 1, 1, mutableListOf())
        val quiz2 = QuizEntity(id = 2, 2, mutableListOf())

        every { quizService.getAllQuizes() } answers {
            mutableListOf(quiz1, quiz2)
        }

        mockMvc.get("/api/quiz/all")
            .andExpect { status { isOk() } }
            .andExpect { content { contentType(MediaType.APPLICATION_JSON) } }
            .andReturn()
    }

}