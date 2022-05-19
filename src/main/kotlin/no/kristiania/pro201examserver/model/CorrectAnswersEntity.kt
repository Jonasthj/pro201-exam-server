package no.kristiania.pro201examserver.model

import javax.persistence.*

@Entity
@Table(name = "correct_answers")
data class CorrectAnswersEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "correct_answers_correct_answer_id_seq")
    @SequenceGenerator(name = "correct_answers_correct_answer_id_seq", allocationSize = 1)
    @Column(name = "correct_answer_id")
    val id: Long? = null,

    @Column(name = "question_id")
    val questionId: Long,

    @Column(name = "answer_id")
    val answerId: Long
)
