package pl.raclacamp.raclaapp.presentation.main


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.materialIcon
import pl.raclacamp.raclaapp.R

sealed class BottomBarScreens(
    val route: String,
    val title: String,
    val iconId: Int
) {
    object Maps : BottomBarScreens(
        route = "maps",
        title = "Map",
        iconId = R.drawable.map_24px

    )

    object Artists : BottomBarScreens(
        route = "artists",
        title = "Line-Up",
        iconId = R.drawable.calendar_today_24px

    )

    object Home : BottomBarScreens(
        route = "home",
        title = "Home",
        iconId = R.drawable.home_24px
    )

    object News : BottomBarScreens(
        route = "news",
        title = "News",
        iconId = R.drawable.newspaper_24px
    )

    object Favorites : BottomBarScreens(
        route = "favorites",
        title = "Favorites",
        iconId = R.drawable.favorite_24px
    )
}
