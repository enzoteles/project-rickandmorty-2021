package com.example.project_rickandmorty_base.presentation.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.project_rickandmorty_base.presentation.ui.screen.character_detail.CharacterDetailScreen
import com.example.project_rickandmorty_base.presentation.ui.screen.filter_character.BottomSheetCharacterScreen
import com.example.project_rickandmorty_base.presentation.ui.screen.filter_character.ListFilterCharacterScreen
import com.example.project_rickandmorty_base.presentation.ui.screen.list_characters.ListCharacterLazyCollun
import com.example.project_rickandmorty_base.presentation.ui.screen.list_characters.TopBarListCharacter
import com.example.project_rickandmorty_base.presentation.ui.viewmodel.filter_character.GetFilterCharactersViewModel
import com.example.project_rickandmorty_base.presentation.ui.viewmodel.list_characteres.GetListCharactersViewModel
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
internal fun MainNavGraph() {
    val navController = rememberNavController()
    val viewModelFilter: GetFilterCharactersViewModel = hiltViewModel()
    val viewModel: GetListCharactersViewModel = hiltViewModel()
    val modalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    val scope = rememberCoroutineScope()
    val stateModel = viewModel.state.value
    val dataSource = viewModel.character

    NavHost(navController = navController, startDestination = Screen.ListCharactersScreen.route) {
        composable(route = Screen.ListCharactersScreen.route) {


            ModalBottomSheetLayout(
                sheetContent = {
                    BottomSheetCharacterScreen (viewModelFilter){
                        navController.popBackStack()
                        navController.navigate(Screen.FilterCharacterBottomSheetScreen.route)
                    }

                },
                sheetState = modalBottomSheetState,
                sheetShape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
            ) {


                Scaffold(
                    topBar = { TopBarListCharacter(viewModelFilter){
                        scope.launch {
                            if (modalBottomSheetState.isVisible.not()) {
                                modalBottomSheetState.animateTo(ModalBottomSheetValue.Expanded)
                                //modalBottomSheetState.show()
                            } else {
                                modalBottomSheetState.hide()
                            }
                        }
                    } },
                    content = {

                        ListCharacterLazyCollun(
                            dataSource = dataSource,
                            state = stateModel,
                        ){ nameScreen->
                            navController.navigate(nameScreen)
                        }
                    },
                )
            }
        }
        composable(
            route = Screen.CharacterDetailScreen.route + "/{characterId}",
        ){
            CharacterDetailScreen{
                navController.popBackStack()
            }
        }

        composable(
            route = Screen.FilterCharacterBottomSheetScreen.route
        ){
                ListFilterCharacterScreen(viewModel = viewModelFilter, nameScreen = { navController.navigate(it)}) {
                   navController.popBackStack()
                    navController.navigate(Screen.FilterCharacterBottomSheetScreen.route)
                }
        }
    }
}



