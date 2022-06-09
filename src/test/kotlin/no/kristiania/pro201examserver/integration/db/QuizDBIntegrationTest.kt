package no.kristiania.pro201examserver.integration.db

import no.kristiania.pro201examserver.services.AnswerInfo
import no.kristiania.pro201examserver.services.QuizService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Import(QuizService::class)
class QuizDBIntegrationTest(@Autowired private val quizService: QuizService) {

    @Test
    fun shouldSavePlayerAnswer(){
        val id: Long = 1
        val timeElapsed = 123F

        val answerInfo = AnswerInfo(id = id, playerId = 1, answerId = 1, questionId = 1, isCorrect = true, timeElapsed = timeElapsed)
        val saved = quizService.savePlayerAnswer(answerInfo)

        assert(saved != null)
        assert(saved?.timeElapsed == timeElapsed)
    }

    @Test
    fun shouldGetQuizById(){
        val quizId: Long = 1

        val quiz = quizService.getQuiz(quizId)

        assert(quiz != null)
        assert(quiz?.questions?.get(0)?.name == "Hvor kan man finne andre hulveier?") // init data from flyway
    }

    @Test
    fun shouldGetAllQuizes(){
        val quizes = quizService.getAllQuizes()

        assert(quizes.size == 7) // init static data from flyway migrations
    }
}