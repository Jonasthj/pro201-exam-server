package no.kristiania.pro201examserver.controller

import no.kristiania.pro201examserver.model.quiz.QuizEntity
import no.kristiania.pro201examserver.services.QuizService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/quiz")
class QuizController(@Autowired private val quizService: QuizService) {

    @CrossOrigin
    @GetMapping
    fun getQuiz(@RequestParam quizId: Long): ResponseEntity<QuizEntity> {
        return ResponseEntity.ok().body(quizService.getQuiz(quizId))
    }

}