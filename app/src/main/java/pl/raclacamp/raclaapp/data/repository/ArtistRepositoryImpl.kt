package pl.raclacamp.raclaapp.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObjects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import pl.raclacamp.raclaapp.app.common.Resource
import pl.raclacamp.raclaapp.data.remote.dto.artist.ArtistDto
import pl.raclacamp.raclaapp.data.remote.dto.artist.toArtist
import pl.raclacamp.raclaapp.domain.model.Artist
import pl.raclacamp.raclaapp.domain.repository.ArtistRepository
import javax.inject.Inject

class ArtistRepositoryImpl @Inject constructor(
    private val db: FirebaseFirestore
) : ArtistRepository {
    override suspend fun getArtistList(): Flow<Resource<List<Artist>>> = flow {
        emit(Resource.Loading())
        try {
            val result = db.collection("artists").get().await()
            require(!result.isEmpty) {
                emit(Resource.Error("No values returned."))
            }
            emit(Resource.Success(result.toObjects<ArtistDto>().map { it.toArtist() }))
        } catch (e: Exception) {
            emit(Resource.Error(e.toString()))
        }
    }


}