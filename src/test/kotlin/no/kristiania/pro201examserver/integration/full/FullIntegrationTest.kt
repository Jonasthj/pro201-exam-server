package no.kristiania.pro201examserver.integration.full

import no.kristiania.pro201examserver.model.player.PlayerEntity
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

    @Test
    fun shouldAddNewUserAndSubmitQuiz(){
        val playerSession = "909090"
        val name = "Petter"
        val avatarIndex = 1

        val newPlayer = PlayerEntity(id = 1, name = name, avatarIndex = avatarIndex, sessionId = playerSession)

        val savedPlayer = mockMvc.post("/api/save/player"){
            contentType = MediaType.APPLICATION_JSON
            content = "{\n" +
                    "    \"name\": \"${name}}\",\n" +
                    "    \"avatarIndex\": ${avatarIndex},\n" +
                    "    \"sessionId\": ${playerSession}\n" +
                    "}"
        }
            .andExpect { status { is2xxSuccessful() } }
            .andReturn()

        /*mockMvc.post("/api/save/player/answer"){
            contentType = MediaType.APPLICATION_JSON
            content = "{\n" +
                    "    \"id\": ${},\n" +
                    "    \"playerId\": ${playerId},\n" +
                    "    \"answerId\": ${answerId},\n" +
                    "    \"questionId\": ${questionId},\n" +
                    "    \"isCorrect\": ${isCorrect},\n" +
                    "    \"timeElapsed\": ${timeElapsed}\n" +
                    "}"
        }
            .andExpect { status { is2xxSuccessful() } }
            .andReturn()*/
    }
}