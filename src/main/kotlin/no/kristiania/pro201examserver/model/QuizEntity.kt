package no.kristiania.pro201examserver.model

import javax.persistence.*

@Entity
@Table(name = "quiz")
data class QuizEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_quiz_id_seq")
    @SequenceGenerator(name = "quiz_quiz_id_seq", allocationSize = 1)
    @Column(name = "quiz_id")
    val id: Long? = null,

    @OneToMany
    @JoinColumn(name = "question_quiz_id")
    val questions: List<QuestionsEntity>
)
