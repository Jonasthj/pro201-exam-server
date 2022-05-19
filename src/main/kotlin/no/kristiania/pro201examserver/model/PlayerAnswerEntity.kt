package no.kristiania.pro201examserver.model

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

    @Column(name = "is_correct")
    val isCorrect: Boolean? = null
)
