package no.kristiania.pro201examserver.unittests.player

import io.mockk.every
import io.mockk.mockk
import no.kristiania.pro201examserver.model.player.PlayerEntity
import no.kristiania.pro201examserver.model.quiz.PlayerAnswerEntity
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
import org.springframework.test.web.servlet.delete
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)
@WebMvcTest
@AutoConfigureMockMvc(addFilters = false)
class PlayerControllerUnitTests {

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
    private lateinit var playerService: PlayerService

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var sessionService: SessionService

    @Autowired
    private lateinit var quizService: QuizService

    @Test
    fun shouldGetAllPlayers() {
        val sessionId = "123"

        val p1Name = "Nick"
        val p2Name = "Jonas"

        val player1 = PlayerEntity(1, p1Name, 0, sessionId)
        val player2 = PlayerEntity(2, p2Name, 1, sessionId)

        every { playerService.findAllPlayers(sessionId) } answers {
            mutableListOf(player1, player2)
        }

        mockMvc.get("/api/session/players?sessionId=${sessionId}")
            .andExpect { status { isOk() } }
            .andExpect { content { contentType(MediaType.APPLICATION_JSON) } }
            .andReturn()
    }

    @Test
    fun shouldSavePlayer(){
        val playerSession = "123"

        val name = "new_player123"
        val avatarIndex = 1
        val newPlayer = PlayerEntity(id = 1, name = name, avatarIndex = avatarIndex, sessionId = playerSession)

        every { playerService.savePlayer(any()) } answers {
            newPlayer
        }

        mockMvc.post("/api/save/player"){
            contentType = MediaType.APPLICATION_JSON
            content = "{\n" +
                    "    \"name\": \"${name}}\",\n" +
                    "    \"avatarIndex\": ${avatarIndex},\n" +
                    "    \"sessionId\": ${playerSession}\n" +
                    "}"
        }
            .andExpect { status { is2xxSuccessful() } }
    }

    @Test
    fun shouldGetPlayerAnswersByPlayer() {
        val playerId: Long = 1
        val id1: Long = 1

        val answer1 = PlayerAnswerEntity(id1, playerId , 1, 1, true, 30f, LocalDateTime.now())
        val answer2 = PlayerAnswerEntity(2, 2, 2, 1, false, 25f, LocalDateTime.now())

        every { playerService.getPlayerAnswersByPlayer(playerId) } answers {
            mutableListOf(answer1, answer2)
        }

        mockMvc.get("/api/quiz/playerAnswer?playerId=${playerId}")
            .andExpect { status { isOk() } }
            .andExpect { content { contentType(MediaType.APPLICATION_JSON) } }
            .andReturn()
    }

    @Test
    fun shouldDeletePlayersBySession() {
        val sessionId = "123"

        every { sessionService.clearSession(sessionId) } answers {
            true
        }

        every { playerService.deletePlayers(sessionId) } answers {
            true
        }

        mockMvc.delete("/api/delete/session?sessionId=${sessionId}")
            .andExpect { status { isOk() } }
            .andReturn()
    }

    @Test
    fun shouldSavePlayerAnswer(){
        val id: Long = 1
        val playerId: Long = 123
        val answerId: Long = 1
        val questionId: Long = 1
        val isCorrect = true
        val timeElapsed = null

        val answerInfo = AnswerInfo(id, playerId, answerId, questionId, isCorrect, timeElapsed)

        // Need to have mock answer for test to run, answer is not necessary
        every { quizService.savePlayerAnswer(answerInfo) } answers {
            nothing
        }

        mockMvc.post("/api/save/player/answer"){
            contentType = MediaType.APPLICATION_JSON
            content = "{\n" +
                    "    \"id\": ${id},\n" +
                    "    \"playerId\": ${playerId},\n" +
                    "    \"answerId\": ${answerId},\n" +
                    "    \"questionId\": ${questionId},\n" +
                    "    \"isCorrect\": ${isCorrect},\n" +
                    "    \"timeElapsed\": ${timeElapsed}\n" +
                    "}"
        }
            .andExpect { status { is2xxSuccessful() } }
    }
}