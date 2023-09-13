package pl.raclacamp.raclaapp.presentation.artists

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.google.firebase.Timestamp
import pl.raclacamp.raclaapp.app.common.DateTimeUtils
import pl.raclacamp.raclaapp.domain.model.Artist
import pl.raclacamp.raclaapp.presentation.home.ArtistItem

@Composable
fun ArtistsScreen(
    viewModel: ArtistsViewModel = hiltViewModel()
) {

    val artistListState = viewModel.artistListState.value

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        ArtistsContent(artists = artistListState.artists)
        if (artistListState.error.isNotBlank()) {
            Text(
                text = artistListState.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (artistListState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Composable
fun ArtistsContent(
    artists: List<Artist>
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(artists) {
            ArtistItem(artist = it)
        }
    }
}

@Composable
fun ArtistItem(
    artist: Artist
) {
    Row {
        AsyncImage(model = artist.imgURL, contentDescription = "Image")
        Column {
            Text(
                text = artist.name.toString(),
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = artist.stage.toString(),
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = DateTimeUtils.formatTimestampToDateString(artist.dateOfPerformance),
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                fontWeight = FontWeight.Light
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ArtistsScreenPreview() {

    val artists = listOf(
        Artist(
            id = "edqKydo4gbjujtu9S1Q1",
            name = "Broda x YFY",
            stage = "Bajzel Stage",
            imgURL = "https://firebasestorage.googleapis.com/v0/b/raclaapp-dev.appspot.com/o/353745875_1116360125948468_5622838432340712572_n.jpg?alt=media&token=dd3e6d44-6e29-47c2-b9b4-a7d58cb5252b",
            dateOfPerformance = Timestamp(1694716200, 473000000),
            description = "🌊 Prezentujemy kolejnych artystów, którzy staną za konsolą na bajzlowej scenie - YFY i Broda, niczym Vincent Vega i Jules Winnfield z Pulp Fiction, zrobią razem show na Racłacamp 2023. ☄️Są członkami kolektywu Techstruction - jedynego takiego projektu zajmującego się muzyką Tech House w Polsce.  YFY to DJ i producent, do którego setów regularnie bawimy się podczas racłacampowych wydarzeń. Jest to też jego wielki powrót do Lasu Ciotki Ulki.  Broda występuje w wielu warszawskich klubach i lokalach prezentując wysokiej klasy selekcję numerów - nie zabraknie ich również na naszym festiwalu. Panowie zagrają wspólnego seta w formule B2B na dwóch różnych konsolach. 🔥"
        ),
        Artist(
            id = "edqKydo4gbjujtu9S1Q1",
            name = "Broda x YFY",
            stage = "Bajzel Stage",
            imgURL = "https://firebasestorage.googleapis.com/v0/b/raclaapp-dev.appspot.com/o/353745875_1116360125948468_5622838432340712572_n.jpg?alt=media&token=dd3e6d44-6e29-47c2-b9b4-a7d58cb5252b",
            dateOfPerformance = Timestamp(1694716200, 473000000),
            description = "🌊 Prezentujemy kolejnych artystów, którzy staną za konsolą na bajzlowej scenie - YFY i Broda, niczym Vincent Vega i Jules Winnfield z Pulp Fiction, zrobią razem show na Racłacamp 2023. ☄️Są członkami kolektywu Techstruction - jedynego takiego projektu zajmującego się muzyką Tech House w Polsce.  YFY to DJ i producent, do którego setów regularnie bawimy się podczas racłacampowych wydarzeń. Jest to też jego wielki powrót do Lasu Ciotki Ulki.  Broda występuje w wielu warszawskich klubach i lokalach prezentując wysokiej klasy selekcję numerów - nie zabraknie ich również na naszym festiwalu. Panowie zagrają wspólnego seta w formule B2B na dwóch różnych konsolach. 🔥"
        )
    )

    ArtistsContent(artists = artists)
}