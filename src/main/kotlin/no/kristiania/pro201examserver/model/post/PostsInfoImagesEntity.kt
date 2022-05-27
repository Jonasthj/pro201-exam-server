package no.kristiania.pro201examserver.model.post

import javax.persistence.*

@Entity
@Table(name = "posts_info_images")
data class PostsInfoImagesEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "posts_info_images_info_img_id_seq")
    @SequenceGenerator(name = "posts_info_images_info_img_id_seq", allocationSize = 1)
    @Column(name = "info_img_id")
    val id: Long? = null,

    @Column(name = "img_uri")
    val imgUri: String
)
