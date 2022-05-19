package no.kristiania.pro201examserver.model

import javax.persistence.*

@Entity
@Table(name = "minigame_scores")
data class MinigameScoresEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "minigame_scores_score_id_seq")
    @SequenceGenerator(name = "minigame_scores_score_id_seq", allocationSize = 1)
    @Column(name = "score_id")
    val id: Long? = null,

    @Column(name = "score_amount")
    val amount: Int? = null,

    @Column(name = "score_time")
    val time: Float? = null,

    @Column(name = "player_id")
    val playerId: Long? = null,

    @Column(name = "minigame_id")
    val minigameId: Long? = null
)
