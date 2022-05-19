package no.kristiania.pro201examserver.controller

import no.kristiania.pro201examserver.model.QuestionsEntity
import no.kristiania.pro201examserver.model.QuizEntity
import no.kristiania.pro201examserver.services.QuizService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/quiz")
class QuizController(@Autowired private val quizService: QuizService) {

    @GetMapping
    fun getQuiz(@RequestParam quizId: Long): ResponseEntity<QuizEntity> {
        return ResponseEntity.ok().body(quizService.getQuiz(quizId))
    }

}