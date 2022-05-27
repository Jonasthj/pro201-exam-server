package no.kristiania.pro201examserver.model.minigame

import javax.persistence.*

@Entity
@Table(name = "histories")
data class HistoriesEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "histories_history_id_seq")
    @SequenceGenerator(name = "histories_history_id_seq", allocationSize = 1)
    @Column(name = "history_id")
    val id: Long? = null,

    @Column(name = "title")
    val title: String,

    @Column(name = "content")
    val content: String,

    @Column(name = "year")
    val year: Int,

    @Column(name = "is_before")
    val isBefore: Boolean,

    @Column(name = "round_id")
    val roundId: Long
)
