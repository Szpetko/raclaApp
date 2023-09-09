package pl.raclacamp.raclaapp.presentation.artists

import pl.raclacamp.raclaapp.domain.model.Artist

data class ArtistListState(
    val isLoading: Boolean = false,
    val artists: List<Artist> = emptyList(),
    val error: String = ""
)
