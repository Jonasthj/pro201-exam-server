package no.kristiania.pro201examserver.model.minigame

import java.time.LocalDateTime
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

    @Column(name = "created")
    val created: LocalDateTime? = LocalDateTime.now(),

    @Column(name = "player_id")
    val playerId: Long? = null,

    @Column(name = "round_id")
    val roundId: Long? = null,

    @OneToOne
    @JoinColumn(name = "round_id", insertable = false, updatable = false)
    val minigameRound: MinigameRoundsEntity? = null,

    )
