package com.example.project_rickandmorty_base.presentation.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.project_rickandmorty_base.data.datasource.RickAndMortkDataSource
import com.example.project_rickandmorty_base.presentation.ui.screen.list_characteres.ListCharacterScreen
import com.example.project_rickandmorty_base.presentation.ui.viewmodel.list_characteres.GetListCharactersViewModel

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
internal fun MainNavGraph() {
    val navController = rememberNavController()
    val viewModel: GetListCharactersViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = Screen.ListCharactersScreen.route) {
        composable(route = Screen.ListCharactersScreen.route) {
            ListCharacterScreen(viewModel){ nameScreen->
                navController.navigate(nameScreen)
            }
        }
        /*composable(
            route = Screen.CommicsDetailScreen.route + "/{index}",
            arguments = listOf(
                navArgument("index"){
                    type = NavType.IntType
                }
            )
        ){ entry->
            val index = entry.arguments?.getInt("index") ?: 0
            viewModel.state.value?.commics?.data?.results?.let { listCharacter ->
                val character = listCharacter[index]
                DetailCharacter(character = character){
                    navController.popBackStack()
                }
            }
        }*/
    }
}



