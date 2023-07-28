package pl.raclacamp.raclaapp.domain.model

import com.google.firebase.Timestamp

data class Artist(
    val id: Int,
    val name: String,
    val stage: String,
    val imgLocation: String,
    val dateOfPerformance: Timestamp,
    val description: String
)
