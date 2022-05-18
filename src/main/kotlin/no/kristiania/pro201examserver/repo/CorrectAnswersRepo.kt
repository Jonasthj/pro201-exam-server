package no.kristiania.pro201examserver.repo

import no.kristiania.pro201examserver.model.CorrectAnswersEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CorrectAnswersRepo : JpaRepository<CorrectAnswersEntity, Long>