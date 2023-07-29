package pl.raclacamp.raclaapp.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObjects
import kotlinx.coroutines.flow.Flow
import pl.raclacamp.raclaapp.app.common.Resource
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import pl.raclacamp.raclaapp.data.remote.dto.artist.ArtistDto
import pl.raclacamp.raclaapp.data.remote.dto.artist.toArtist
import pl.raclacamp.raclaapp.domain.model.Artist
import pl.raclacamp.raclaapp.domain.repository.ArtistRepository
import java.lang.NullPointerException
import javax.inject.Inject

class ArtistRepositoryImpl @Inject constructor(
    private val db: FirebaseFirestore
): ArtistRepository {
    override suspend fun getArtistList(): Flow<Resource<List<Artist>>> =  flow {
        emit(Resource.Loading())
        try {
            val response = db.collection("artists")
                .get()
                .addOnSuccessListener { result ->
//                    if(result != null){
//                        result
//                    } else {
//                        throw NullPointerException()
//                    }
                    val artists = result.toObjects<ArtistDto>().map { it.toArtist() }
                    Resource.Success(artists)
                }
                .addOnFailureListener { exception ->
                    //Log.w(TAG, "Error getting documents.", exception)
                    throw exception
                }
                .await()
//            val artistList = response.toObjects<ArtistDto>().map{ it.toArtist() }
//            emit(Resource.Success(artistList))
        }catch (e: Exception){
            emit(Resource.Error(e.toString()))
        }
    }


}