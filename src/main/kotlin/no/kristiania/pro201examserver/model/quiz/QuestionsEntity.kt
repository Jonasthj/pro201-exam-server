package no.kristiania.pro201examserver.model.quiz

import javax.persistence.*

@Entity
@Table(name = "questions")
data class QuestionsEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questions_question_id_seq")
    @SequenceGenerator(name = "questions_question_id_seq", allocationSize = 1)
    @Column(name = "question_id")
    val id: Long? = null,

    @Column(name = "question_name")
    val name: String,

    @Column(name = "question_quiz_id")
    val quizId: Int,

    @OneToMany
    @JoinColumn(name = "question_id")
    val answers: List<AnswersEntity>,

    )
