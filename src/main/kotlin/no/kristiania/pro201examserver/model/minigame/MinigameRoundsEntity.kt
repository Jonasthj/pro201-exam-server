package no.kristiania.pro201examserver.model.minigame

import javax.persistence.*

@Entity
@Table(name = "minigame_rounds")
data class MinigameRoundsEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "minigame_rounds_round_id_seq")
    @SequenceGenerator(name = "minigame_rounds_round_id_seq", allocationSize = 1)
    @Column(name = "round_id")
    val id: Long? = null,

    @Column(name = "minigame_id")
    val minigameId: Long,

    @Column(name = "language_id")
    val languageId: Long,

    @Column(name = "post_id")
    val postId: Long
)
