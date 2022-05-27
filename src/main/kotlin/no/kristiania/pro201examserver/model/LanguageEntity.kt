package no.kristiania.pro201examserver.model

import javax.persistence.*

@Entity
@Table(name = "languages")
data class LanguageEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "languages_language_id_seq")
    @SequenceGenerator(name = "languages_language_id_seq", allocationSize = 1)
    @Column(name = "language_id")
    val id: Long? = null,

    @Column(name = "name")
    val name: String,

    @Column(name = "flag_uri")
    val flagUri: String? = null
)
