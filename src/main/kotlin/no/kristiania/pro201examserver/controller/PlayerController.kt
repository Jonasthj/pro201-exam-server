package no.kristiania.pro201examserver.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class PlayerController {

    @GetMapping("/all")
    fun getTest() : ResponseEntity<String> {
        return ResponseEntity.ok().body("Test succeded")
    }
}