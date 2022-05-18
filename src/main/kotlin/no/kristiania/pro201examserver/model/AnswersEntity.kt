package no.kristiania.pro201examserver.model

import javax.persistence.*

@Entity
@Table(name = "answers")
data class AnswersEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answers_answer_id_seq")
    @SequenceGenerator(name = "answers_answer_id_seq", allocationSize = 1)
    @Column(name = "answer_id")
    val id: Long? = null,

    @Column(name = "answer_name")
    val name: String,

    @Column(name = "answer_question_id")
    val questionId: Int
)
