package no.kristiania.pro201examserver.model.post

import javax.persistence.*

@Entity
@Table(name = "posts")
data class PostsEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "posts_post_id_seq")
    @SequenceGenerator(name = "posts_post_id_seq", allocationSize = 1)
    @Column(name = "post_id")
    val id: Long? = null,

    @Column(name = "name")
    val name: String,

    @Column(name = "quiz_id")
    val quizId: Long,

    @Column(name = "language_id")
    val languageId: Long,

    @OneToOne
    @JoinColumn(name = "post_id")
    val postInfo: PostsInfoEntity? = null
)