package no.kristiania.pro201examserver.model.quiz

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "players_has_answers")
data class PlayerAnswerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "players_has_answers_id_seq")
    @SequenceGenerator(name = "players_has_answers_id_seq", allocationSize = 1)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "player_id")
    val playerId: Long? = null,

    @Column(name = "answer_id")
    val answerId: Long? = null,

    @Column(name = "question_id")
    val questionid: Long? = null,

    @Column(name = "is_correct")
    val isCorrect: Boolean? = null,

    @Column(name = "time_elapsed")
    val timeElapsed: Float? = null,

    @Column(name = "created")
    val created: LocalDateTime? = LocalDateTime.now(),

    @OneToOne
    @JoinColumn(name = "question_id", insertable = false, updatable = false)
    val question: QuestionsEntity? = null
)
