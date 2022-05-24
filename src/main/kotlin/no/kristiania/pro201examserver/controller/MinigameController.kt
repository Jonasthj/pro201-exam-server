package no.kristiania.pro201examserver.controller

import no.kristiania.pro201examserver.model.MinigameEntity
import no.kristiania.pro201examserver.services.MinigameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/minigame")
class MinigameController(
    @Autowired private val minigameSerice: MinigameService
) {

    @GetMapping("/all")
    fun getMinigames(): ResponseEntity<List<MinigameEntity>> {
        return ResponseEntity.ok().body(minigameSerice.getMinigames())
    }

}