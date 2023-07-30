package pl.raclacamp.raclaapp.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import pl.raclacamp.raclaapp.domain.usecase.artist.GetArtistList
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getArtistList: GetArtistList
): ViewModel() {

    init {
        getArtists()
    }

    private fun getArtists(){
        viewModelScope.launch {
            getArtistList().collect(){
                response ->
                Log.v("home", response.data.toString())
            }
        }
    }

}