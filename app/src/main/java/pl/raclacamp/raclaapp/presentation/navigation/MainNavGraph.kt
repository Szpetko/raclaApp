package pl.raclacamp.raclaapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pl.raclacamp.raclaapp.presentation.artists.ArtistsScreen
import pl.raclacamp.raclaapp.presentation.favorites.FavoritesScreen
import pl.raclacamp.raclaapp.presentation.home.HomeScreen
import pl.raclacamp.raclaapp.presentation.main.BottomBarScreens
import pl.raclacamp.raclaapp.presentation.maps.MapsScreen
import pl.raclacamp.raclaapp.presentation.news.NewsScreen

@Composable
fun MainNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreens.Home.route
    ) {
        composable(route = BottomBarScreens.Maps.route) {
            MapsScreen()
        }
        composable(route = BottomBarScreens.Artists.route) {
            ArtistsScreen()
        }
        composable(route = BottomBarScreens.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreens.News.route) {
            NewsScreen()
        }
        composable(route = BottomBarScreens.Favorites.route) {
            FavoritesScreen()
        }
    }
}


