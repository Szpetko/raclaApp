package pl.raclacamp.raclaapp.domain.repository


import kotlinx.coroutines.flow.Flow
import pl.raclacamp.raclaapp.app.common.Resource
import pl.raclacamp.raclaapp.data.remote.dto.artist.ArtistDto
import pl.raclacamp.raclaapp.domain.model.Artist


interface ArtistRepository {

    suspend fun getArtistList(): Flow<Resource<List<Artist>>>
}