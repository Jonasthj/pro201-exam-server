package no.kristiania.pro201examserver.services

import no.kristiania.pro201examserver.model.quiz.PlayerAnswerEntity
import no.kristiania.pro201examserver.model.quiz.QuizEntity
import no.kristiania.pro201examserver.repo.quiz.PlayerAnswerRepo
import no.kristiania.pro201examserver.repo.quiz.QuizRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class QuizService(
    @Autowired private val quizRepo: QuizRepo,
    @Autowired private val playerAnswerRepo: PlayerAnswerRepo
    ) {

    fun savePlayerAnswer(answerInfo: AnswerInfo): PlayerAnswerEntity {
        val playerAnswerEntity = PlayerAnswerEntity(
            answerInfo.id,
            answerInfo.playerId,
            answerInfo.answerId,
            answerInfo.isCorrect
        )
        return playerAnswerRepo.save(playerAnswerEntity)
    }

    fun getQuiz(quizId: Long): QuizEntity? {
        return quizRepo.findQuizEntityById(quizId)
    }

}

data class  AnswerInfo(
    val id: Long?, val playerId: Long?, val answerId: Long?, val isCorrect: Boolean?, val timeElapsed: Float?
)