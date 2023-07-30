package pl.raclacamp.raclaapp.data.remote.dto.artist

import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentId
import pl.raclacamp.raclaapp.domain.model.Artist

data class ArtistDto(
    @DocumentId
    val id: String? = null,
    val name: String? = null,
    val stage: String? = null,
    val rank: Double? = null,
    val imgLocation: String? = null,
    val imgURL: String? = null,
    val dateOfPerformance: Timestamp? = null,
    val description: String? = null
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
