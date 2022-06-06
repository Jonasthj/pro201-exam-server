package no.kristiania.pro201examserver.controller

import no.kristiania.pro201examserver.model.post.PostsEntity
import no.kristiania.pro201examserver.model.post.PostsInfoEntity
import no.kristiania.pro201examserver.services.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/post")
class PostController(@Autowired private val postService: PostService) {

    @CrossOrigin
    @GetMapping("/all")
    fun getPosts(): ResponseEntity<List<PostsEntity>> {
        return ResponseEntity.ok().body(postService.getPosts())
    }

    @CrossOrigin
    @GetMapping("/info/all")
    fun getPostInfos(): ResponseEntity<List<PostsInfoEntity>> {
        return ResponseEntity.ok().body(postService.getPostInfos())
    }

}