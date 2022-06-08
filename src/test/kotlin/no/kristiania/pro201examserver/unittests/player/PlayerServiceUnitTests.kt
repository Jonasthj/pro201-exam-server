package no.kristiania.pro201examserver.unittests.player

import io.mockk.every
import io.mockk.mockk
import no.kristiania.pro201examserver.model.player.PlayerEntity
import no.kristiania.pro201examserver.model.player.SessionEntity
import no.kristiania.pro201examserver.model.quiz.PlayerAnswerEntity
import no.kristiania.pro201examserver.repo.player.PlayerRepo
import no.kristiania.pro201examserver.repo.quiz.PlayerAnswerRepo
import no.kristiania.pro201examserver.services.MinigameService
import no.kristiania.pro201examserver.services.PlayerInfo
import no.kristiania.pro201examserver.services.PlayerService
import no.kristiania.pro201examserver.services.SessionService
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

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
    fun shouldGetPlayerAnswersByPlayer() {

        val playerId: Long = 1

        val id1: Long = 1

        val answer1 = PlayerAnswerEntity(id1, playerId , 1, true, 30f, LocalDateTime.now())
        val answer2 = PlayerAnswerEntity(2, 2, 2, false, 25f, LocalDateTime.now())

        every { playerAnswerRepo.findAllByPlayerId(playerId)} answers {
            mutableListOf(answer1, answer2)
        }

        val answers = playerService.getPlayerAnswersByPlayer(playerId)

        assert(answers?.first { it.id == id1 }?.isCorrect == true)
        assert(answers?.first { it.id == id1 }?.playerId == playerId)

    }

    @Test
    fun shouldDeletePlayersBySession() {
        val sessionId = "123"

        val playerName1 = "Player 1"
        val playerName2 = "Player 2"

        val player1 = PlayerEntity(1, playerName1, 0, sessionId)
        val player2 = PlayerEntity(2, playerName2, 0, sessionId)

        every { playerRepo.findAllBySessionId(sessionId) } answers {
            mutableListOf(player1, player2)
        }

        every { minigameService.deleteScores(any()) } answers {
        }

        every { playerRepo.deleteById(any()) } answers {
        }

        val didDelete = playerService.deletePlayers(sessionId)

        assert(didDelete)
        assertFalse(!didDelete)
    }

}