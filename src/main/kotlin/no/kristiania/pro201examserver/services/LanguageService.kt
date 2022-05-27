package no.kristiania.pro201examserver.services

import no.kristiania.pro201examserver.model.LanguageEntity
import no.kristiania.pro201examserver.repo.LanguageRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LanguageService(@Autowired private val languageRepo: LanguageRepo) {
    fun getLanguages(): List<LanguageEntity>? {
        return languageRepo.findAll()
    }
}