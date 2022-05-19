package no.kristiania.pro201examserver.controller

import no.kristiania.pro201examserver.model.MinigameScoresEntity
import no.kristiania.pro201examserver.services.MinigameScoresService
import no.kristiania.pro201examserver.services.ScoresInfo
import no.kristiania.pro201examserver.services.SessionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/api")
class PlayerController(
    @Autowired private val minigameScoresService: MinigameScoresService,
    @Autowired private val sessionService: SessionService
    ) {

    @GetMapping("/test")
    fun getTest() : ResponseEntity<String> {
        return ResponseEntity.ok().body("Test succeeded")
    }

    @DeleteMapping("/delete/session")
    fun clearSession(@RequestParam sessionId: String): ResponseEntity<String> {

        val response = sessionService.clearSession(sessionId)

        if(response) {
            return ResponseEntity.ok().body("Session cleared")
        }

        return ResponseEntity.badRequest().build()
    }

    @PostMapping("/save/score/minigame")
    fun saveMinigameScore(@RequestBody scoresInfo: ScoresInfo): ResponseEntity<MinigameScoresEntity> {
        val created = minigameScoresService.saveScore(scoresInfo)
        val uri =
            URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/save/score/minigame").toUriString())
        return ResponseEntity.created(uri).body(created)
    }

}