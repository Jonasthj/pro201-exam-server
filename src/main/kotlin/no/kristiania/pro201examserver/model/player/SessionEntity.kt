package no.kristiania.pro201examserver.model.player

import javax.persistence.*

@Entity
@Table(name = "sessions")
data class SessionEntity(
    @Id
    @Column(name = "session_id")
    val id: String
)
