package no.kristiania.pro201examserver.integration.full

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import no.kristiania.pro201examserver.model.player.PlayerEntity
import no.kristiania.pro201examserver.services.ScoresInfo
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class FullIntegrationTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun shouldAddNewUserAndSubmitQuiz(){
        val playerSession = "909090"
        val name = "Petter"
        val avatarIndex = 1

        val savedPlayerResponse = mockMvc.post("/api/save/player"){
            contentType = MediaType.APPLICATION_JSON
            content = "{\n" +
                    "    \"name\": \"${name}}\",\n" +
                    "    \"avatarIndex\": ${avatarIndex},\n" +
                    "    \"sessionId\": ${playerSession}\n" +
                    "}"
        }
            .andExpect { status { is2xxSuccessful() } }
            .andReturn()

        val player: PlayerEntity = objectMapper.readValue(savedPlayerResponse.response.contentAsString, PlayerEntity::class.java)

        mockMvc.post("/api/save/player/answer"){
            contentType = MediaType.APPLICATION_JSON
            content = "{\n" +
                    "    \"id\": ${null},\n" +
                    "    \"playerId\": ${player.id},\n" +
                    "    \"answerId\": ${1},\n" +
                    "    \"questionId\": ${1},\n" +
                    "    \"isCorrect\": ${false},\n" +
                    "    \"timeElapsed\": ${22}\n" +
                    "}"
        }
            .andExpect { status { is2xxSuccessful() } }
            .andReturn()
    }

    @Test
    fun shouldCreateUserAndSaveMinigamescore(){
        val playerSession = "909090"
        val name = "Petter"
        val avatarIndex = 1

        val savedPlayerResponse = mockMvc.post("/api/save/player"){
            contentType = MediaType.APPLICATION_JSON
            content = "{\n" +
                    "    \"name\": \"${name}}\",\n" +
                    "    \"avatarIndex\": ${avatarIndex},\n" +
                    "    \"sessionId\": ${playerSession}\n" +
                    "}"
        }
            .andExpect { status { is2xxSuccessful() } }
            .andReturn()

        val scoresInfo = ScoresInfo(id = null, amount = 123, time = 1F, created = null, playerId = 1, roundId = 1)

        mockMvc.post("/api/save/score/minigame"){
            contentType = MediaType.APPLICATION_JSON
            content = "{\n" +
                    "    \"amount\": ${scoresInfo.amount},\n" +
                    "    \"time\": ${scoresInfo.time},\n" +
                    "    \"playerId\": ${scoresInfo.playerId},\n" +
                    "    \"roundId\": ${scoresInfo.roundId}\n" +
                    "}"
        }
            .andExpect { status { is2xxSuccessful() } }
            .andReturn()
    }
}