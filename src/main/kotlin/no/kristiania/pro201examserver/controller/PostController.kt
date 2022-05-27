package no.kristiania.pro201examserver.controller

import no.kristiania.pro201examserver.model.post.PostsEntity
import no.kristiania.pro201examserver.model.post.PostsInfoEntity
import no.kristiania.pro201examserver.services.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/post")
class PostController(@Autowired private val postService: PostService) {

    @GetMapping("/all")
    fun getPosts(): ResponseEntity<List<PostsEntity>> {
        return ResponseEntity.ok().body(postService.getPosts())
    }

    @GetMapping("/info")
    fun getPostInfo(@RequestParam postId: Long): ResponseEntity<PostsInfoEntity> {
        return ResponseEntity.ok().body(postService.getPostInfo(postId))
    }

    @GetMapping("/info/all")
    fun getPostInfos(): ResponseEntity<List<PostsInfoEntity>> {
        return ResponseEntity.ok().body(postService.getPostInfos())
    }

}