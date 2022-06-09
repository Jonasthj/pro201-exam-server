package no.kristiania.pro201examserver.integration.db

import no.kristiania.pro201examserver.services.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Import(PostService::class)
class PostDBIntegrationTest(@Autowired private val postService: PostService) {

    @Test
    fun shouldGetAllPosts(){
        val posts = postService.getPosts()

        assert(posts != null)
        assert(posts?.size == 7) // init data from flyway migrations
    }

    @Test
    fun shouldGetAllPostInfos(){
        val postInfos = postService.getPostInfos()

        assert(postInfos != null)
        assert(postInfos?.size == 7) // init data from flyway migrations
    }

}