package no.kristiania.pro201examserver.model.minigame

import javax.persistence.*

@Entity
@Table(name = "memorycards")
data class MemoryCardsEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memorycards_memory_id_seq")
    @SequenceGenerator(name = "memorycards_memory_id_seq", allocationSize = 1)
    @Column(name = "memory_id")
    val id: Long? = null,

    @Column(name = "image_uri")
    val imageUri: String,

    @Column(name = "round_id")
    val roundId: Long
)
