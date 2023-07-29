package pl.raclacamp.raclaapp.domain.usecase.artist

import pl.raclacamp.raclaapp.domain.repository.ArtistRepository
import javax.inject.Inject

class GetArtistList @Inject constructor(
    private val repository: ArtistRepository
) {
    suspend operator fun invoke() = repository.getArtistList()
}