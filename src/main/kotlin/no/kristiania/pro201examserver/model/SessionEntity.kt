package no.kristiania.pro201examserver.model

import javax.persistence.*

@Entity
@Table(name = "session")
data class SessionEntity(

    @Id
    @Column(name = "session_id")
    val id: String
)
