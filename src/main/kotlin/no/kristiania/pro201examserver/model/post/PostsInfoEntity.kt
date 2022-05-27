package no.kristiania.pro201examserver.model.post

import javax.persistence.*

@Entity
@Table(name = "posts_info")
data class PostsInfoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "posts_info_info_id_seq")
    @SequenceGenerator(name = "posts_info_info_id_seq", allocationSize = 1)
    @Column(name = "info_id")
    val id: Long? = null,

    @Column(name = "intro_txt")
    val introTxt: String? = null,

    @Column(name = "info_header")
    val infoHeader: String? = null,

    @Column(name = "info_identify")
    val infoIdentity: Int? = null,

    @Column(name = "info_content")
    val infoContent: String? = null,

    @Column(name = "model_uri")
    val modelUri: String? = null,

    @Column(name = "post_id")
    val postId: Long,

    @Column(name = "info_img_id")
    val infoImgId: Long
)
