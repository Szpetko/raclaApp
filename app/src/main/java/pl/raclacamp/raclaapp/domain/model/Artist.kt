package pl.raclacamp.raclaapp.domain.model

import com.google.firebase.Timestamp

data class Artist(
    val id: String? = null,
    val name: String? = null,
    val stage: String? = null,
    val imgURL: String? = null,
    val dateOfPerformance: Timestamp? = null,
    val description: String? = null
)
