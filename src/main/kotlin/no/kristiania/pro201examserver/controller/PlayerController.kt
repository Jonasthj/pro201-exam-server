package no.kristiania.pro201examserver.controller

import no.kristiania.pro201examserver.model.LanguageEntity
import no.kristiania.pro201examserver.model.minigame.MinigameScoresEntity
import no.kristiania.pro201examserver.model.quiz.PlayerAnswerEntity
import no.kristiania.pro201examserver.model.player.PlayerEntity
import no.kristiania.pro201examserver.services.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/api")
class PlayerController(
    @Autowired private val minigameScoresService: MinigameService,
    @Autowired private val sessionService: SessionService,
    @Autowired private val playerService: PlayerService,
    @Autowired private val quizService: QuizService
    ) {

    @CrossOrigin
    @DeleteMapping("/delete/session")
    fun clearSession(@RequestParam sessionId: String): ResponseEntity<String> {

        val playerResponse = playerService.deletePlayers(sessionId)
        val sessionResponse = sessionService.clearSession(sessionId)

        if(sessionResponse && playerResponse) {
            return ResponseEntity.ok().body("Session cleared")
        }

        return ResponseEntity.badRequest().build()
    }

    @CrossOrigin
    @PostMapping("/save/score/minigame")
    fun saveMinigameScore(@RequestBody scoresInfo: ScoresInfo): ResponseEntity<MinigameScoresEntity> {
        val created = minigameScoresService.saveScore(scoresInfo)
        val uri =
            URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/save/score/minigame").toUriString())
        return ResponseEntity.created(uri).body(created)
    }

    @CrossOrigin
    @PostMapping("/save/player")
    fun savePlayer(@RequestBody playerInfo: PlayerInfo) : ResponseEntity<PlayerEntity> {
        val created = playerService.savePlayer(playerInfo)
        val uri =
            URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/save/player").toUriString())
        return ResponseEntity.created(uri).body(created)
    }

    @CrossOrigin
    @PostMapping("/save/player/answer")
    fun savePlayerAnswer(@RequestBody answerInfo: AnswerInfo): ResponseEntity<PlayerAnswerEntity> {
        val created = quizService.savePlayerAnswer(answerInfo)
        val uri =
            URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/save/player/answer").toUriString())
        return ResponseEntity.created(uri).body(created)
    }

    @CrossOrigin
    @GetMapping("/session/players")
    fun getPlayers(@RequestParam sessionId: String): ResponseEntity<List<PlayerEntity>> {
        return ResponseEntity.ok().body(playerService.findAllPlayers(sessionId))
    }

    @CrossOrigin
    @GetMapping("/player")
    fun getPlayer(@RequestParam playerId: Long): ResponseEntity<PlayerEntity> {
        return ResponseEntity.ok().body(playerService.getPlayer(playerId))
    }

    @CrossOrigin
    @GetMapping("/session/quiz/playerAnswer")
    fun getPlayerAnswers(@RequestParam sessionId: String) : ResponseEntity<List<PlayerAnswerEntity>>{
        return ResponseEntity.ok().body(playerService.getPlayerAnswers(sessionId))
    }
}