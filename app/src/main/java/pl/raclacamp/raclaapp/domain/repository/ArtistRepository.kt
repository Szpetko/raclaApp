package pl.raclacamp.raclaapp.domain.repository

import com.google.android.gms.common.api.Response
import kotlinx.coroutines.flow.Flow
import pl.raclacamp.raclaapp.data.remote.dto.artist.ArtistDto
import pl.raclacamp.raclaapp.domain.model.Artist


interface ArtistRepository {

    suspend fun getArtistList(): List<ArtistDto>
}