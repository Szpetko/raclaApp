package pl.raclacamp.raclaapp.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pl.raclacamp.raclaapp.app.common.Resource
import pl.raclacamp.raclaapp.domain.usecase.artist.GetArtistList
import pl.raclacamp.raclaapp.presentation.artists.ArtistListState
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getArtistList: GetArtistList
) : ViewModel() {


    private val _artistListState = mutableStateOf(ArtistListState())
    val artistListState: State<ArtistListState> = _artistListState

    init {
        getArtists()
    }

    private fun getArtists() {
        viewModelScope.launch {
            getArtistList().collect() { response ->
                when (response) {
                    is Resource.Error -> {
                        _artistListState.value = ArtistListState(
                            error = response.message ?: "An unexpected Error occurred"
                        )
                    }

                    is Resource.Loading -> {
                        _artistListState.value = ArtistListState(isLoading = true)
                    }

                    is Resource.Success -> {
                        _artistListState.value = ArtistListState(
                            artists = response.data ?: emptyList()
                        )
                    }
                }
            }
        }
    }

}