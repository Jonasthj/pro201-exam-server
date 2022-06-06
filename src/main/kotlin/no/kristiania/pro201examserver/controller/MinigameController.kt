package no.kristiania.pro201examserver.controller

import no.kristiania.pro201examserver.model.minigame.MinigameEntity
import no.kristiania.pro201examserver.model.minigame.MinigameRoundsEntity
import no.kristiania.pro201examserver.services.MinigameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/minigame")
class MinigameController(
    @Autowired private val minigameService: MinigameService
) {

    @CrossOrigin
    @GetMapping("/all")
    fun getMinigames(): ResponseEntity<List<MinigameEntity>> {
        return ResponseEntity.ok().body(minigameService.getMinigames())
    }

    @CrossOrigin
    @GetMapping("/round/all")
    fun getMinigameRounds(): ResponseEntity<List<MinigameRoundsEntity>> {
        return ResponseEntity.ok().body(minigameService.getMinigameRounds())
    }

    @CrossOrigin
    @GetMapping("/round")
    fun getMinigameRound(@RequestParam roundId: Long): ResponseEntity<MinigameRoundsEntity> {
        return ResponseEntity.ok().body(minigameService.getMinigameRound(roundId))
    }

    @GetMapping("/round/game")
    fun getRoundsByMinigame(@RequestParam minigameId: Long): ResponseEntity<List<MinigameRoundsEntity>> {
        return ResponseEntity.ok().body(minigameService.getRoundsByMinigame(minigameId))
    }

}