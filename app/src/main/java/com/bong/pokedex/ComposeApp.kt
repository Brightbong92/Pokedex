package com.bong.pokedex

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bong.pokedex.ui.list.ListScreen
import com.bong.pokedex.ui.list.ListViewModel

@Composable
fun ComposeApp() {
    val navController = rememberNavController()

    val listViewModel: ListViewModel = viewModel()

    NavHost(navController = navController, startDestination = Route.LIST) {
        composable(Route.LIST) {
            ListScreen(viewModel = listViewModel)
//            UsersScreen(
//                onUserClick = { username ->
//                    // In order to discard duplicated navigation events, we check the Lifecycle
//                    if (backStackEntry.lifecycle.currentState == Lifecycle.State.RESUMED) {
//                        navController.navigate("${Route.DETAIL}/$username")
//                    }
//                }
//            )
        }
//        composable(
//            route = "${Route.DETAIL}/{${Argument.USERNAME}}",
//            arguments = listOf(
//                navArgument(Argument.USERNAME) {
//                    type = NavType.StringType
//                }
//            ),
//        ) {
//            DetailsScreen()
//        }
    }
}

object Route {
    const val LIST = "list"
    const val DETAIL = "detail"
}

object Argument {
    const val POKEMON_NAME = "pokemonName"
}