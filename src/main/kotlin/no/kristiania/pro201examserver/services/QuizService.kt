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
    @Autowired private val playerAnswerRepo: PlayerAnswerRepo,
    ) {

    fun savePlayerAnswer(answerInfo: AnswerInfo): PlayerAnswerEntity? {
        if(answerInfo.playerId != null && answerInfo.questionId != null) {
            val playerAnswer = playerAnswerRepo.getByPlayerIdAndAndQuestionId(answerInfo.playerId, answerInfo.questionId)

            val playerAnswerEntity = PlayerAnswerEntity(
                id = playerAnswer?.id,
                playerId = answerInfo.playerId,
                answerId = answerInfo.answerId ?: playerAnswer?.answerId,
                questionId = answerInfo.questionId,
                isCorrect = answerInfo.isCorrect ?: playerAnswer?.isCorrect,
                timeElapsed = answerInfo.timeElapsed ?: playerAnswer?.timeElapsed,
            )
            return playerAnswerRepo.save(playerAnswerEntity)
        }

        return null
    }

    fun getQuiz(quizId: Long): QuizEntity? {
        return quizRepo.findQuizEntityById(quizId)
    }

    fun getAllQuizes(): List<QuizEntity> {
        return quizRepo.findAll()
    }

    fun deleteAnswers(id: Long?) {
        quizRepo.deleteAllById(id)
    }

}

data class AnswerInfo(
    val id: Long?, val playerId: Long?, val answerId: Long?, val questionId: Long?, val isCorrect: Boolean?, val timeElapsed: Float?
)