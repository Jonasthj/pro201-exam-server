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
@Import(MinigameService::class, PlayerService::class, SessionService::class, QuizService::class)
class MinigameDBIntegrationTest(
    @Autowired private val minigameService: MinigameService,
    @Autowired private val playerService: PlayerService,
    @Autowired private val sessionService: SessionService,
    @Autowired private val quizService: QuizService

    ) {

    @Test
    fun shouldGetAllMinigames() {
        val minigames = minigameService.getMinigames()

        assert(minigames != null)
        assert(minigames?.size == 4)
    }

    @Test
    fun shouldGetMinigameRounds() {
        val rounds = minigameService.getMinigameRounds()

        assert(rounds != null)
        assert(rounds?.size == 21)
    }

    @Test
    fun shouldGetMiniGameRoundById() {
        val roundId: Long = 1

        val minigameId: Long = 1 // known init data from flyway
        val round = minigameService.getMinigameRound(roundId)

        assert(round?.minigameId == minigameId)
    }

    @Test
    fun shouldGetRoundsByPostId() {
        val postId: Long = 1

        val rounds = minigameService.getRoundsByPost(postId)

        assert(rounds != null)
        assert(rounds?.size == 3)
    }

    @Test
    fun shouldSaveMinigameScore() {
        val time = 123F

        val scoresInfo = ScoresInfo(id = 1, amount = 1, time = time, created = null, playerId = 1, roundId = 1)

        val saved = minigameService.saveScore(scoresInfo)

        assert(saved != null)
        assert(saved?.time == time)
    }

    /*@Test
    fun shouldSaveAndDeleteMinigameScoresByPlayerId() {
        TODO!
        val time = 123F
        val playerId: Long = 123

        val playerInfo = PlayerInfo(id = playerId, name = "Petter", avatarIndex = 1, sessionId = "909090")

        playerService.savePlayer(playerInfo)

        val scoresInfo = ScoresInfo(id = playerId, amount = 1, time = time, created = null, playerId = 1, roundId = 1)

        val saved = minigameService.saveScore(scoresInfo)

        assert(saved != null)
        assert(saved?.time == time)

        minigameService.deleteScores(playerId)

        val retrieved = playerService.getPlayer(playerId)

        assert(retrieved?.minigameScores != null)
        retrieved?.minigameScores?.let { assert(it.isEmpty()) }
    }*/
}