package no.kristiania.pro201examserver.repo.quiz

import no.kristiania.pro201examserver.model.quiz.QuizEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
interface QuizRepo : JpaRepository<QuizEntity, Long> {

    fun findQuizEntityById(quizId: Long): QuizEntity?

    @Transactional
    fun deleteAllById(id: Long?)
}