package no.kristiania.pro201examserver.unittests.minigame

import io.mockk.every
import io.mockk.mockk
import no.kristiania.pro201examserver.model.minigame.MinigameEntity
import no.kristiania.pro201examserver.model.minigame.MinigameRoundsEntity
import no.kristiania.pro201examserver.model.minigame.MinigameScoresEntity
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
import org.springframework.test.web.servlet.post
import java.time.LocalDateTime

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
    private lateinit var minigameService: MinigameService

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun shouldGetAllMinigames(){
        val id1: Long = 1
        val id2: Long = 2

        val m1Name = "Saw"
        val m2Name = "Memory"

        val minigame1 = MinigameEntity(id = id1, name = m1Name)
        val minigame2 = MinigameEntity(id = id2, name = m2Name)

        every { minigameService.getMinigames() } answers {
            mutableListOf(minigame1, minigame2)
        }

        mockMvc.get("/api/minigame/all")
            .andExpect { status { isOk() } }
            .andExpect { content { contentType(MediaType.APPLICATION_JSON) } }
            .andReturn()
    }

    @Test
    fun shouldGetAllMinigameRounds(){
        val id1: Long = 1
        val id2: Long = 2

        val roundNumber1 = 11
        val roundNumber2 = 22

        val minigameRound1 = MinigameRoundsEntity(id = id1, roundNumber = roundNumber1, minigameId = 1, languageId = 1, postId = 1)
        val minigameRound2 = MinigameRoundsEntity(id = id2, roundNumber = roundNumber2, minigameId = 2, languageId = 2, postId = 1)

        every { minigameService.getMinigameRounds() } answers {
            mutableListOf(minigameRound1, minigameRound2)
        }

        mockMvc.get("/api/minigame/round/all")
            .andExpect { status { isOk() } }
            .andExpect { content { contentType(MediaType.APPLICATION_JSON) } }
            .andReturn()
     }

    @Test
    fun shouldGetMinigameRound(){

        val id1: Long = 1
        val roundNumber1 = 11

        val minigameRound1 = MinigameRoundsEntity(id = id1, roundNumber = roundNumber1, minigameId = 1, languageId = 1, postId = 1)

        every { minigameService.getMinigameRound(id1) } answers {
            minigameRound1
        }

        mockMvc.get("/api/minigame/round?roundId=${id1}")
            .andExpect { status { isOk() } }
            .andExpect { content { contentType(MediaType.APPLICATION_JSON) } }
            .andReturn()
    }

    @Test
    fun shouldGetRoundsByMinigame(){
        val id1: Long = 1
        val id2: Long = 2

        val postId: Long = 1

        val roundNumber1 = 11
        val roundNumber2 = 22

        val minigameRound1 = MinigameRoundsEntity(id = id1, roundNumber = roundNumber1, minigameId = 1, languageId = 1, postId = postId)
        val minigameRound2 = MinigameRoundsEntity(id = id2, roundNumber = roundNumber2, minigameId = 2, languageId = 2, postId = postId)

        every { minigameService.getRoundsByPost(postId) } answers {
            mutableListOf(minigameRound1, minigameRound2)
        }

        mockMvc.get("/api/minigame/round/game?postId=${postId}")
            .andExpect { status { isOk() } }
            .andExpect { content { contentType(MediaType.APPLICATION_JSON) } }
            .andReturn()
    }

    @Test
    fun shouldSaveMinigameScore(){

        val id1: Long = 1
        val amount = 1
        val time = 1F
        val playerId: Long = 1
        val roundId: Long = 1
        val timestamp = LocalDateTime.now()

        val scoresInfo = ScoresInfo(id = null, amount= amount, time = time, playerId = playerId, roundId = roundId, created = null)
        val minigameScore = MinigameScoresEntity(id = id1, created = timestamp)


        every { minigameService.saveScore(scoresInfo) } answers {
            minigameScore
        }

        mockMvc.post("/api/save/score/minigame") {
            contentType = MediaType.APPLICATION_JSON
            content = "{\n" +
                    "    \"amount\": ${amount},\n" +
                    "    \"time\": ${time},\n" +
                    "    \"playerId\": ${playerId},\n" +
                    "    \"roundId\": ${roundId}\n" +
                    "}"
        }
            .andExpect { status { is2xxSuccessful() } }
            .andExpect { content { contentType(MediaType.APPLICATION_JSON) } }
            .andReturn()
    }
}