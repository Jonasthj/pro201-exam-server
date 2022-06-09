package no.kristiania.pro201examserver.unittests.minigame

import io.mockk.every
import io.mockk.mockk
import no.kristiania.pro201examserver.model.minigame.MinigameEntity
import no.kristiania.pro201examserver.model.minigame.MinigameRoundsEntity
import no.kristiania.pro201examserver.model.minigame.MinigameScoresEntity
import no.kristiania.pro201examserver.repo.minigame.MinigameRepo
import no.kristiania.pro201examserver.repo.minigame.MinigameRoundsRepo
import no.kristiania.pro201examserver.repo.minigame.MinigameScoresRepo
import no.kristiania.pro201examserver.services.MinigameService
import no.kristiania.pro201examserver.services.ScoresInfo
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class MinigameServiceUnitTests {

    private val minigameRepo = mockk<MinigameRepo>()
    private val minigameScoresRepo = mockk<MinigameScoresRepo>()
    private val minigameRoundsRepo = mockk<MinigameRoundsRepo>()
    private val minigameService = MinigameService(minigameRepo, minigameScoresRepo, minigameRoundsRepo)

    @Test
    fun shouldGetMinigames(){
        val minigame1Id: Long = 1
        val minigame2Id: Long = 2

        val minigame1Name = "Memory"
        val minigame2Name = "Saw"

        val minigame1 = MinigameEntity(id = minigame1Id, name = minigame1Name)
        val minigame2 = MinigameEntity(id = minigame2Id, name = minigame2Name)

        every { minigameRepo.findAll() } answers {
            mutableListOf(minigame1, minigame2)
        }

        val retrieved = minigameService.getMinigames()

        assert(retrieved != null)
        assert(retrieved?.size == 2)
        assert(retrieved?.first { it.id == minigame1Id }?.name == minigame1Name)
        assert(retrieved?.first { it.id == minigame2Id }?.name == minigame2Name)
    }

    @Test
    fun shouldGetMinigameRounds(){
        val minigameRoundId1: Long = 1
        val minigameRoundId2: Long = 2

        val minigameRoundNumber1 = 1
        val minigameRoundNumber2 = 2

        val minigameRound1 = MinigameRoundsEntity(id = minigameRoundId1, roundNumber = minigameRoundNumber1, minigameId = 1, languageId = 1, postId = 1)
        val minigameRound2 = MinigameRoundsEntity(id = minigameRoundId2, roundNumber = minigameRoundNumber2, minigameId = 2, languageId = 2, postId = 2)

        every { minigameRoundsRepo.findAll() } answers {
            mutableListOf(minigameRound1, minigameRound2)
        }

        val retrieved = minigameService.getMinigameRounds()

        assert(retrieved != null)
        assert(retrieved?.size == 2)
        assert(retrieved?.first { it.id == minigameRoundId1 }?.roundNumber == minigameRoundNumber1)
        assert(retrieved?.first { it.id == minigameRoundId2 }?.roundNumber == minigameRoundNumber2)
    }

    @Test
    fun shouldGetMinigameRound(){

        val minigameId: Long = 1

        val minigameRound = MinigameRoundsEntity(id = minigameId, roundNumber = 14, minigameId = 1, languageId = 1, postId = 1)

        every { minigameRoundsRepo.getById(minigameId) } answers {
            minigameRound
        }

        val retrieved = minigameService.getMinigameRound(minigameId)

        assert(retrieved != null)
        assert(retrieved?.id == minigameId)
        assert(retrieved?.roundNumber == 14)
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

        every { minigameRoundsRepo.getAllByPostId(postId) } answers {
            mutableListOf(minigameRound1, minigameRound2)
        }

        val retrieved = minigameService.getRoundsByMinigame(postId)

        assert(retrieved != null)
        assert(retrieved?.size == 2)
        assert(retrieved?.first { it.id == id1 }?.roundNumber == roundNumber1)
        assert(retrieved?.first { it.id == id2 }?.roundNumber == roundNumber2)
    }

    @Test
    fun shouldSaveMinigameScore(){

        val id1: Long = 1
        val playerId: Long = 1
        val roundId: Long = 1
        val timestamp1 = LocalDateTime.now()

        val scoresInfo = ScoresInfo(1, 1, 1F, created = timestamp1, playerId = playerId, roundId = roundId)
        val minigameScore = MinigameScoresEntity(id = id1, created = timestamp1)


        every { minigameScoresRepo.save(any()) } answers {
            minigameScore
        }

        every { minigameScoresRepo.getByPlayerIdAndRoundId(playerId, roundId) }  answers {
            minigameScore
        }

        val saved = minigameService.saveScore(scoresInfo)

        assert(saved != null)
        assert(saved?.id == id1)
        assert(saved?.created == timestamp1)
    }

    /*@Test
    fun deleteScores(){

        TODO: Delete scores has no return value, how to mock?

        val id1: Long = 1
        val playerId: Long = 1
        val roundId: Long = 1
        val timestamp1 = LocalDateTime.now()

        val scoresInfo = ScoresInfo(1, 1, 1F, created = timestamp1, playerId = playerId, roundId = roundId)
        val minigameScore = MinigameScoresEntity(id = id1, created = timestamp1)

        every { minigameScoresRepo.save(any()) } answers {
            minigameScore
        }

        every { minigameScoresRepo.getByPlayerIdAndRoundId(playerId, roundId) }  answers {
            minigameScore
        }

        val saved = minigameService.saveScore(scoresInfo)

        assert(saved != null)
        assert(saved?.id == id1)
        assert(saved?.created == timestamp1)

        minigameService.deleteScores(playerId)

        val result = minigameScoresRepo.findAll()

        assert(result.size == 0)
    }*/






}