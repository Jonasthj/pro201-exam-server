package no.kristiania.pro201examserver.repo

import no.kristiania.pro201examserver.model.quiz.QuizEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuizRepo : JpaRepository<QuizEntity, Long> {
    fun findQuizEntityById(quizId: Long): QuizEntity?
}