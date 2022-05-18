package no.kristiania.pro201examserver.model

import javax.persistence.*

@Entity
@Table(name = "session")
data class SessionEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "session_id_seq")
    @SequenceGenerator(name = "session_id_seq", allocationSize = 1)
    @Column(name = "session_id")
    val id: Long? = null,
)
