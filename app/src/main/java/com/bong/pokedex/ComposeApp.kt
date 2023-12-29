package com.bong.pokedex

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bong.pokedex.Argument.POKEMON_NAME
import com.bong.pokedex.ui.detail.DetailScreen
import com.bong.pokedex.ui.detail.DetailViewModel
import com.bong.pokedex.ui.list.ListScreen
import com.bong.pokedex.ui.list.ListViewModel


@Composable
fun ComposeApp() {
    val navController = rememberNavController()
    val listViewModel: ListViewModel = viewModel()
    val detailViewModel: DetailViewModel = viewModel()

    NavigationProvider(navController = navController) {
        NavHost(
            navController = navController, startDestination = Route.LIST,
            // 기본 FadeInOut 효과 제거됨
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }
        ) {
            composable(route = Route.LIST) {
                ListScreen(viewModel = listViewModel)
            }
            composable(
                enterTransition = {
                    fadeIn(
                        animationSpec = tween(
                            100, easing = LinearEasing
                        )
                    ) + slideIntoContainer(
                        animationSpec = tween(100, easing = EaseIn),
                        towards = AnimatedContentTransitionScope.SlideDirection.Start
                    )
                },
//                exitTransition = {
//                    fadeOut(
//                        animationSpec = tween(
//                            100, easing = LinearEasing
//                        )
//                    ) + slideOutOfContainer(
//                        animationSpec = tween(100, easing = EaseOut),
//                        towards = AnimatedContentTransitionScope.SlideDirection.End
//                    )
//                },
                route = "${Route.DETAIL}/{${POKEMON_NAME}}",
                arguments = listOf(
                    navArgument(POKEMON_NAME) {
                        type = NavType.StringType
                    }),
            ) { backStackEntry ->
                backStackEntry.arguments?.getString(POKEMON_NAME)?.let {
                    DetailScreen(viewModel = detailViewModel, name = it, onClickBack = {
                        navController.popBackStack()
                    })
                }
            }
            // composable END
        }
    }
}


object Route {
    const val LIST = "list"
    const val DETAIL = "detail"
}

object Argument {
    const val POKEMON_NAME = "name"
}