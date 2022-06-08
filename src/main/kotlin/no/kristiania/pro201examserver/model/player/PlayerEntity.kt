package no.kristiania.pro201examserver.model.player

import no.kristiania.pro201examserver.model.minigame.MinigameScoresEntity
import no.kristiania.pro201examserver.model.quiz.PlayerAnswerEntity
import javax.persistence.*

@Entity
@Table(name = "players")
data class PlayerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "players_player_id_seq")
    @SequenceGenerator(name = "players_player_id_seq", allocationSize = 1)
    @Column(name = "player_id")
    val id: Long? = null,

    @Column(name = "player_name")
    val name: String? = null,

    @Column(name = "player_avatar_index")
    val avatarIndex: Int? = null,

    @Column(name = "player_session_id")
    val sessionId: String? = null,

    @OneToMany
    @JoinColumn(name = "player_id")
    val minigameScores: List<MinigameScoresEntity>? = null,

    @OneToMany
    @JoinColumn(name = "player_id")
    val quizAnswers: List<PlayerAnswerEntity>? = null
)
