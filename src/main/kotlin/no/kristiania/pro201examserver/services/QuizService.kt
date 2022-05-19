package no.kristiania.pro201examserver.services

import no.kristiania.pro201examserver.model.PlayerAnswerEntity
import no.kristiania.pro201examserver.repo.PlayerAnswerRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class QuizService(@Autowired private val playerAnswerRepo: PlayerAnswerRepo) {

    fun savePlayerAnswer(answerInfo: AnswerInfo): PlayerAnswerEntity {
        val playerAnswerEntity = PlayerAnswerEntity(
            answerInfo.id,
            answerInfo.playerId,
            answerInfo.answerId,
            answerInfo.isCorrect
        )
        return playerAnswerRepo.save(playerAnswerEntity)
    }

}

data class AnswerInfo(
    val id: Long?, val playerId: Long?, val answerId: Long?, val isCorrect: Boolean?
)