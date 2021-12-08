package com.example.project_rickandmorty_base.presentation.ui.screen.filter_character

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.example.project_rickandmorty_base.commons.utils.TestTags
import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper
import com.example.project_rickandmorty_base.presentation.ui.components.CircularIndeterminateProgressBarComponent
import com.example.project_rickandmorty_base.presentation.ui.screen.Screen
import com.example.project_rickandmorty_base.presentation.ui.screen.integration_tests.CharacterListItem
import com.example.project_rickandmorty_base.presentation.ui.screen.integration_tests.TopBarListCharacter
import com.example.project_rickandmorty_base.presentation.ui.viewmodel.filter_character.GetFilterCharactersViewModel
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun ListFilterCharacterScreen(
    viewModel: GetFilterCharactersViewModel,
    nameScreen: (String) -> Unit,
    topBarClick: () -> Unit
) {
    val stateModel = viewModel.state.value
    val dataSource = viewModel.character
    val characterListItem: LazyPagingItems<CharacterMapper> = dataSource.collectAsLazyPagingItems()
    val modalBottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetContent = {
            BottomSheetCharacterScreen(viewModel = viewModel) {
                topBarClick.invoke()
            }
        },
        sheetState = modalBottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
    ) {
        Scaffold(
            topBar = {
                TopBarListCharacter {
                    scope.launch {
                        if (modalBottomSheetState.isVisible.not()) {
                            modalBottomSheetState.animateTo(ModalBottomSheetValue.Expanded)
                        } else {
                            modalBottomSheetState.hide()
                        }
                    }
                }
            },
            content = {
                Box(modifier = Modifier.fillMaxSize()) {
                    //loading
                    CircularIndeterminateProgressBarComponent(isDisplayed = stateModel.isLoading)

                    //content
                    if (stateModel.isLoading.not() && stateModel.error.isBlank()) {
                        LazyVerticalGrid(
                            cells = GridCells.Fixed(2),
                            contentPadding = PaddingValues(8.dp),
                            modifier = Modifier.testTag(TestTags.CHARACTER_ITEM_SELECTED_FILTER),
                        ) {
                            items(characterListItem.itemCount) { index ->
                                val character = characterListItem[index]
                                CharacterListItem(item = character) { id ->
                                    nameScreen(Screen.CharacterDetailScreen.route + "/$id")
                                }
                            }
                        }

                    }

                    //error
                    if (stateModel.error.isNotBlank()) {
                        Text(
                            text = "Not found character",
                            color = MaterialTheme.colors.error,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
            }
        )
    }
}





