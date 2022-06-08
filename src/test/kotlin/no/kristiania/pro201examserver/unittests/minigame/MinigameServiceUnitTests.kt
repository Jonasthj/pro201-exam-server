package no.kristiania.pro201examserver.unittests.minigame

import io.mockk.every
import io.mockk.mockk
import no.kristiania.pro201examserver.model.quiz.QuizEntity
import no.kristiania.pro201examserver.repo.quiz.PlayerAnswerRepo
import no.kristiania.pro201examserver.repo.quiz.QuizRepo
import no.kristiania.pro201examserver.services.QuizService
import org.junit.jupiter.api.Test

class MinigameServiceUnitTests {

    private val quizRepo = mockk<QuizRepo>()
    private val playerAnswerRepo = mockk<PlayerAnswerRepo>()
    private val quizService = QuizService(quizRepo, playerAnswerRepo)

    @Test
    fun shouldGetQuiz(){
        val quizId: Long = 1
        val quiz = QuizEntity(id = 1, 1, mutableListOf())

        every { quizService.getQuiz(quizId) } answers {
            quiz
        }

        val retrieved = quizService.getQuiz(quizId)

        assert(retrieved != null)
        assert(retrieved?.id == quizId)
    }

    @Test
    fun shouldGetQuizzes(){
        val quiz1Id: Long = 1
        val quiz2Id: Long = 2

        val quiz1 = QuizEntity(id = 1, 1, mutableListOf())
        val quiz2 = QuizEntity(id = 2, 2, mutableListOf())

        every { quizService.getAllQuizes() } answers {
            mutableListOf(quiz1, quiz2)
        }

        val retrieved = quizService.getAllQuizes()

        assert(retrieved.size == 2)
        assert(retrieved.first { it.id == quiz1Id }?.languageId == quiz1.languageId)
        assert(retrieved.first { it.id == quiz2Id }?.languageId == quiz2.languageId)
    }






}