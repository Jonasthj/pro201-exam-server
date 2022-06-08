package no.kristiania.pro201examserver.unittests.player

import io.mockk.every
import io.mockk.mockk
import no.kristiania.pro201examserver.model.player.PlayerEntity
import no.kristiania.pro201examserver.model.player.SessionEntity
import no.kristiania.pro201examserver.repo.player.PlayerRepo
import no.kristiania.pro201examserver.repo.quiz.PlayerAnswerRepo
import no.kristiania.pro201examserver.services.MinigameService
import no.kristiania.pro201examserver.services.PlayerInfo
import no.kristiania.pro201examserver.services.PlayerService
import no.kristiania.pro201examserver.services.SessionService
import org.junit.jupiter.api.Test

class PlayerServiceUnitTests {

    private val playerRepo = mockk<PlayerRepo>()
    private val sessionService = mockk<SessionService>()
    private val minigameService = mockk<MinigameService>()
    private val playerAnswerRepo = mockk<PlayerAnswerRepo>()
    private val playerService = PlayerService(playerRepo, sessionService, minigameService, playerAnswerRepo)

    @Test
    fun shouldGetPlayersBySession() {

        val playerSession = "123"

        val playerOneId: Long = 1
        val playerTwoId: Long = 2

        val playerOneName = "Petter"
        val playerTwoName = "Kari"

        val playerOne = PlayerEntity(playerOneId, playerOneName, 0, playerSession)
        val playerTwo = PlayerEntity(2, playerTwoName, 0, playerSession)

        every { playerRepo.findAllBySessionId(any()) } answers {
            mutableListOf(playerOne, playerTwo)
        }

        val players = playerService.findAllPlayers(playerSession)

        assert(players != null)
        assert(players?.size == 2)
        assert(players?.first { it.id == playerOneId }?.name == playerOneName)
        assert(players?.first { it.id == playerTwoId }?.name == playerTwoName)
    }

    @Test
    fun shouldSavePlayer() {

        val playerSession = "123"

        val name = "new_player123"
        val avatarIndex = 1
        val newPlayer = PlayerEntity(id = 1, name = name, avatarIndex = avatarIndex, sessionId = playerSession)

        val newSession = SessionEntity(playerSession)

        every { sessionService.saveSession(any()) } answers {
            newSession
        }

        every { playerRepo.save(any()) } answers {
            newPlayer
        }

        val playerInfo = PlayerInfo(null, name, avatarIndex, playerSession)
        val createdPlayer = playerService.savePlayer(playerInfo)

        assert(createdPlayer.name == name)
        assert(createdPlayer.sessionId == playerSession)

    }

    @Test
    fun shouldDeletePlayersBySession() {

    }

}