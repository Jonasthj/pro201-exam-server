package no.kristiania.pro201examserver.model

import javax.persistence.*

@Entity
@Table(name = "minigame_scores")
data class MinigameScoresEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "minigames_id_seq")
    @SequenceGenerator(name = "minigames_id_seq", allocationSize = 1)
    @Column(name = "minigame_id")
    val id: Long? = null,

    @Column(name = "minigame_amount")
    val amount: Int,

    @Column(name = "minigame_time")
    val time: Float,

    @Column(name = "minigame_player_id")
    val playerId: Long? = null
)
