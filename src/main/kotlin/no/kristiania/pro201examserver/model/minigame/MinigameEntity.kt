package no.kristiania.pro201examserver.model.minigame

import javax.persistence.*

@Entity
@Table(name = "minigames")
data class MinigameEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "minigames_minigame_id_seq")
    @SequenceGenerator(name = "minigames_minigame_id_seq", allocationSize = 1)
    @Column(name = "minigame_id")
    val id: Long? = null,

    @Column(name = "name")
    val name: String,

)
