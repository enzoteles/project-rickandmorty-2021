package com.example.project_rickandmorty_base.presentation.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Constraints
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.example.project_rickandmorty_base.commons.utils.Constants
import com.example.project_rickandmorty_base.data.remote.character_detail.toCharacter
import com.example.project_rickandmorty_base.data.remote.list_characters.ListCharacters
import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper
import com.example.project_rickandmorty_base.domain.model.list_characters.ListCharactersMapper
import com.example.project_rickandmorty_base.presentation.ui.screen.character_detail.CharacterDetailScreen
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
        composable(
            route = Screen.CharacterDetailScreen.route + "/{characterId}",
        ){
            CharacterDetailScreen()
        }
    }
}



