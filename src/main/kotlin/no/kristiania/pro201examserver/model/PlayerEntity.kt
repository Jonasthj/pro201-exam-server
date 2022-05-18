package no.kristiania.pro201examserver.model

import javax.persistence.*

@Entity
@Table(name = "players")
data class PlayerEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_id_seq")
    @SequenceGenerator(name = "player_id_seq", allocationSize = 1)
    @Column(name = "player_id")
    val id: Long? = null,

    @Column(name = "player_name")
    val name: String,

    @Column(name = "player_avatar_index")
    val avatarIndex: Int,

    @Column(name = "player_session_id")
    val sessionId: Int
)
