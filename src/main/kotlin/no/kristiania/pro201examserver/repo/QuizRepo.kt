package no.kristiania.pro201examserver.repo

import no.kristiania.pro201examserver.model.QuizEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuizRepo : JpaRepository<QuizEntity, Long>