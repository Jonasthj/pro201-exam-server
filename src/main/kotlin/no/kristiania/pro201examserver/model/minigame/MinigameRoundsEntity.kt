package no.kristiania.pro201examserver.model.minigame

import javax.persistence.*

@Entity
@Table(name = "minigame_rounds")
data class MinigameRoundsEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "minigame_rounds_round_id_seq")
    @SequenceGenerator(name = "minigame_rounds_round_id_seq", allocationSize = 1)
    @Column(name = "round_id")
    val id: Long? = null,

    @Column(name = "round_number")
    val roundNumber: Int,

    @Column(name = "minigame_id")
    val minigameId: Long,

    @Column(name = "language_id")
    val languageId: Long,

    @Column(name = "post_id")
    val postId: Long,

    @OneToMany
    @JoinColumn(name = "round_id")
    val memoryCards: List<MemoryCardsEntity>? = null,

    @OneToMany
    @JoinColumn(name = "round_id")
    val histories: List<HistoriesEntity>? = null,

    @OneToMany
    @JoinColumn(name = "round_id")
    val words: List<WordsEntity>? = null
)
