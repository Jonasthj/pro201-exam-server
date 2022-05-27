package no.kristiania.pro201examserver.model.minigame

import javax.persistence.*

@Entity
@Table(name = "words")
data class WordsEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "words_word_id_seq")
    @SequenceGenerator(name = "words_word_id_seq", allocationSize = 1)
    @Column(name = "word_id")
    val id: Long? = null,

    @Column(name = "word")
    val word: String,

    @Column(name = "round_id")
    val roundId: Long
)
