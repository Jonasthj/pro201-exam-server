package no.kristiania.pro201examserver.model

import javax.persistence.*

@Entity
@Table(name = "correct_answers")
data class CorrectAnswersEntity(

    @Id
    @Column(name = "question_id")
    val questionId: Long? = null,

    @Id
    @Column(name = "answer_id")
    val answerId: Long? = null
)
