package no.kristiania.pro201examserver.repo

import no.kristiania.pro201examserver.model.AnswersEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnswersRepo : JpaRepository<AnswersEntity, Long>