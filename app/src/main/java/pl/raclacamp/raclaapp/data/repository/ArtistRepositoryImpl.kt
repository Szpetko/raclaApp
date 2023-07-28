package pl.raclacamp.raclaapp.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import pl.raclacamp.raclaapp.data.remote.dto.artist.ArtistDto
import pl.raclacamp.raclaapp.domain.repository.ArtistRepository
import javax.inject.Inject

class ArtistRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
): ArtistRepository {
    override suspend fun getArtistList(): List<ArtistDto> {
        TODO("Not yet implemented")
    }

}