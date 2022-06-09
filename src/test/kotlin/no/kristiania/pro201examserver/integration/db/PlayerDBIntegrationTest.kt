package no.kristiania.pro201examserver.integration.db

import no.kristiania.pro201examserver.services.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Import(PlayerService::class, SessionService::class, MinigameService::class, QuizService::class)
class PlayerDBIntegrationTest(
    @Autowired private val playerService: PlayerService,
    @Autowired private val sessionService: SessionService,
    @Autowired private val minigameService: MinigameService,
    @Autowired private val quizService: QuizService
) {

    @Test
    fun shouldAddTwoAndFindAllPlayersInSession(){
        val sessionId = "999999"
        val playerInfo1 = PlayerInfo(id = null, name = "Petter", avatarIndex = 1, sessionId = sessionId)
        val playerInfo2 = PlayerInfo(id = null, name = "Kjartan", avatarIndex = 1, sessionId = sessionId)

        val saved1 = playerService.savePlayer(playerInfo1)
        val saved2 = playerService.savePlayer(playerInfo2)

        assert(saved1.name == saved1.id?.let { playerService.getPlayer(it)?.name })
        assert(saved2.name == saved2.id?.let { playerService.getPlayer(it)?.name })

        val sessionPlayers = playerService.findAllPlayers(sessionId)

        assert(sessionPlayers != null)
        assert(sessionPlayers?.size == 2)
        assert(sessionPlayers?.first { it.id == saved1.id }?.name == saved1.name)
        assert(sessionPlayers?.first { it.id == saved2.id }?.name == saved2.name)
    }

    @Test
    fun shouldAddAndRetrievePlayer(){
        val sessionId = "8888888"
        val playerInfo = PlayerInfo(id = null, name = "Petter", avatarIndex = 1, sessionId = sessionId)
        val saved = playerService.savePlayer(playerInfo)

        assert(saved.name == saved.id?.let { playerService.getPlayer(it)?.name })
    }

    @Test
    fun shouldAddAndDeletePlayer(){
        val sessionId = "7777777"
        val playerInfo1 = PlayerInfo(id = null, name = "Petter", avatarIndex = 1, sessionId = sessionId)
        val playerInfo2 = PlayerInfo(id = null, name = "Kjartan", avatarIndex = 1, sessionId = sessionId)

        val saved1 = playerService.savePlayer(playerInfo1)
        val saved2 = playerService.savePlayer(playerInfo2)

        assert(saved1.name == saved1.id?.let { playerService.getPlayer(it)?.name })
        assert(saved2.name == saved2.id?.let { playerService.getPlayer(it)?.name })

        val sessionPlayers = playerService.findAllPlayers(sessionId)

        assert(sessionPlayers != null)
        assert(sessionPlayers?.size == 2)
        assert(sessionPlayers?.first { it.id == saved1.id }?.name == saved1.name)
        assert(sessionPlayers?.first { it.id == saved2.id }?.name == saved2.name)

        playerService.deleteById(saved2.id)

        val sessionPlayersAfterDeletion = playerService.findAllPlayers(sessionId)

        assert(sessionPlayersAfterDeletion?.size == 1)
    }

    @Test
    fun shouldAddTwoAndDeleteAllPlayersInSession(){
        val sessionId = "6666666"
        val playerInfo1 = PlayerInfo(id = null, name = "Petter", avatarIndex = 1, sessionId = sessionId)
        val playerInfo2 = PlayerInfo(id = null, name = "Kjartan", avatarIndex = 1, sessionId = sessionId)

        val saved1 = playerService.savePlayer(playerInfo1)
        val saved2 = playerService.savePlayer(playerInfo2)

        assert(saved1.name == saved1.id?.let { playerService.getPlayer(it)?.name })
        assert(saved2.name == saved2.id?.let { playerService.getPlayer(it)?.name })

        val sessionPlayers = playerService.findAllPlayers(sessionId)

        assert(sessionPlayers != null)
        assert(sessionPlayers?.size == 2)
        assert(sessionPlayers?.first { it.id == saved1.id }?.name == saved1.name)
        assert(sessionPlayers?.first { it.id == saved2.id }?.name == saved2.name)

        val deleteStatus = playerService.deletePlayers(sessionId)

        val sessionPlayersAfterDeletion = playerService.findAllPlayers(sessionId)

        assert(deleteStatus)
        assert(sessionPlayersAfterDeletion?.size == 0)

    }

    @Test
    fun shouldDeleteSession(){
        val sessionId = "5555555"
        val playerInfo = PlayerInfo(id = null, name = "Petter", avatarIndex = 1, sessionId = sessionId)

        playerService.savePlayer(playerInfo) // Saving the player creates the session)

        val status = playerService.deletePlayers(sessionId)

        assert(status)
    }

    @Test
    fun shouldGetPlayerAnswersByPlayerId(){
        val sessionId = "4444444"
        val playerInfo = PlayerInfo(id = null, name = "Petter", avatarIndex = 1, sessionId = sessionId)

        val savedPlayer = playerService.savePlayer(playerInfo)

        val playerAnswers = savedPlayer.id?.let { playerService.getPlayerAnswersByPlayer(it) }

        assert(playerAnswers != null)
        playerAnswers?.let { assert(it.isEmpty()) }

        val answerInfo = AnswerInfo(id = null, playerId = savedPlayer.id, answerId = 1, questionId = 1, isCorrect = false, timeElapsed = 1F)
        quizService.savePlayerAnswer(answerInfo)

        val updatedPlayerAnswers = savedPlayer.id?.let { playerService.getPlayerAnswersByPlayer(it) }

        assert(updatedPlayerAnswers != null)
        assert(updatedPlayerAnswers?.size == 1)
    }
}