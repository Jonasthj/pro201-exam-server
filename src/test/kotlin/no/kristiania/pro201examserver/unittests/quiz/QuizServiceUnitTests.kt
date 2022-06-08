package no.kristiania.pro201examserver.unittests.quiz

import io.mockk.every
import io.mockk.mockk
import no.kristiania.pro201examserver.model.post.PostsEntity
import no.kristiania.pro201examserver.model.post.PostsInfoEntity
import no.kristiania.pro201examserver.model.quiz.PlayerAnswerEntity
import no.kristiania.pro201examserver.model.quiz.QuizEntity
import no.kristiania.pro201examserver.repo.player.PlayerRepo
import no.kristiania.pro201examserver.repo.post.PostInfoRepo
import no.kristiania.pro201examserver.repo.post.PostRepo
import no.kristiania.pro201examserver.repo.quiz.PlayerAnswerRepo
import no.kristiania.pro201examserver.repo.quiz.QuizRepo
import no.kristiania.pro201examserver.services.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class QuizServiceUnitTests {

    private val quizRepo = mockk<QuizRepo>()
    private val playerRepo = mockk<PlayerRepo>()
    private val sessionService = mockk<SessionService>()
    private val minigameService = mockk<MinigameService>()
    private val playerAnswerRepo = mockk<PlayerAnswerRepo>()
    private val playerService = PlayerService(playerRepo, sessionService, minigameService, playerAnswerRepo)
    private val quizService = QuizService(quizRepo, playerAnswerRepo)

    @Test
    fun shouldGetQuiz() {
        val quizId: Long = 1
        val quiz = QuizEntity(id = 1, 1, mutableListOf())

        every { quizRepo.findQuizEntityById(quizId) } answers {
            quiz
        }

        val retrieved = quizService.getQuiz(quizId)

        assert(retrieved != null)
        assert(retrieved?.id == quizId)
    }

    @Test
    fun shouldGetQuizzes() {
        val quiz1Id: Long = 1
        val quiz2Id: Long = 2

        val quiz1 = QuizEntity(id = 1, 1, mutableListOf())
        val quiz2 = QuizEntity(id = 2, 2, mutableListOf())

        every { quizRepo.findAll() } answers {
            mutableListOf(quiz1, quiz2)
        }

        val retrieved = quizService.getAllQuizes()

        assert(retrieved.size == 2)
        assert(retrieved.first { it.id == quiz1Id }?.languageId == quiz1.languageId)
        assert(retrieved.first { it.id == quiz2Id }?.languageId == quiz2.languageId)
    }

    @Test
    fun shouldSavePlayerAnswer() {
        val id: Long = 1
        val timeElapsed = 13F

        val newPlayerAnswer = PlayerAnswerEntity(id = id, timeElapsed = timeElapsed)

        every { playerAnswerRepo.save(any()) } answers {
            newPlayerAnswer
        }

        val created = playerAnswerRepo.save(newPlayerAnswer)

        assert(created.id == newPlayerAnswer.id)
        assert(created.timeElapsed == newPlayerAnswer.timeElapsed)
    }


}