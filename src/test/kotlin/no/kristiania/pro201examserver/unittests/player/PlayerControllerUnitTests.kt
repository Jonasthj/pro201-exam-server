package no.kristiania.pro201examserver.unittests.player

import io.mockk.every
import io.mockk.mockk
import no.kristiania.pro201examserver.model.player.PlayerEntity
import no.kristiania.pro201examserver.services.PlayerService
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
class PlayerControllerUnitTests {

    @TestConfiguration
    class ControllerTestConfig {
        @Bean
        fun playerService() = mockk<PlayerService>()
    }

    @Autowired
    private lateinit var playerService: PlayerService

    @Autowired
    private lateinit var mockMvc: MockMvc

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

        mockMvc.get("/api/session/players")
            .andExpect { status { isOk() } }
            .andExpect { content { contentType(MediaType.APPLICATION_JSON) } }
            .andReturn()
    }

}