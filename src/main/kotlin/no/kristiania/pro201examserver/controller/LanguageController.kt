package no.kristiania.pro201examserver.controller

import no.kristiania.pro201examserver.model.LanguageEntity
import no.kristiania.pro201examserver.services.LanguageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/language")
class LanguageController(@Autowired private val languageService: LanguageService) {

    @GetMapping("/all")
    fun getLanguages(): ResponseEntity<List<LanguageEntity>> {
        return ResponseEntity.ok().body(languageService.getLanguages())
    }

}