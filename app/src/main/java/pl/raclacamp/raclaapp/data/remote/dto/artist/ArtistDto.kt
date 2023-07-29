package pl.raclacamp.raclaapp.data.remote.dto.artist

import com.google.firebase.Timestamp
import pl.raclacamp.raclaapp.domain.model.Artist

data class ArtistDto(
    val id: String,
    val name: String,
    val stage: String,
    val rank: Int,
    val imgLocation: String,
    val imgURL: String,
    val dateOfPerformance: Timestamp,
    val description: String
)

fun ArtistDto.toArtist(): Artist{
    return Artist(
        id = id,
        name = name,
        stage = stage,
        imgLocation = imgLocation,
        dateOfPerformance = dateOfPerformance,
        description = description
    )
}
