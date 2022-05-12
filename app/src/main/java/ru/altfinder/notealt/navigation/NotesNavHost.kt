package ru.altfinder.notealt.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.altfinder.notealt.MainViewModel
import ru.altfinder.notealt.screens.*

sealed class NavRoute(val route: String) {
    object  Start: NavRoute(route ="start_screen" )
    object  Main: NavRoute(route ="main_screen" )
    object  Add: NavRoute(route ="add_screen" )
    object  Note: NavRoute(route ="note_screen" )
}

@Composable
fun NotesNavHost(mViewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.Start.route) {
        composable(NavRoute.Start.route) { StartScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Main.route) { MainScreen(navController = navController , viewModel = mViewModel) }
        composable(NavRoute.Add.route) { AddScreen(navController = navController , viewModel = mViewModel)  }
        composable(NavRoute.Note.route) { NoteScreen(navController = navController , viewModel = mViewModel) }
        

    }
}