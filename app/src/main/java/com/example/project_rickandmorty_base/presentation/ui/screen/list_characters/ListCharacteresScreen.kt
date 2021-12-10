package com.example.project_rickandmorty_base.presentation.ui.screen.integration_tests

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.project_rickandmorty_base.R
import com.example.project_rickandmorty_base.commons.utils.TestTags
import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper
import com.example.project_rickandmorty_base.presentation.ui.components.CircularIndeterminateProgressBarComponent
import com.example.project_rickandmorty_base.presentation.ui.components.GenericsUiState
import com.example.project_rickandmorty_base.presentation.ui.components.topbar.MenuAction
import com.example.project_rickandmorty_base.presentation.ui.screen.Screen
import kotlinx.coroutines.flow.Flow

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun TopBarListCharacter(
    onClickFilter: () -> Unit
) {
    val menuFilterIcon = MenuAction.Filter.icon
    val menuFilterLabel = MenuAction.Filter.label
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.list_screen),
            modifier = Modifier.testTag(TestTags.TITLE_LIST_CHARACTER_BAR))
        },

        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 12.dp,
        actions = {
            IconButton(onClick = { onClickFilter() }) {
                Icon(
                    painter = painterResource(id = menuFilterIcon)
                    , contentDescription = stringResource(id = menuFilterLabel)
                )
            }
        }
    )
}


@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun ListCharacterLazyCollun(
    dataSource: Flow<PagingData<CharacterMapper>>,
    state: GenericsUiState<List<CharacterMapper>>,
    nameScreen: (String) -> Unit
) {
    val characterListItem: LazyPagingItems<CharacterMapper> = dataSource.collectAsLazyPagingItems()
    Box(modifier = Modifier.fillMaxSize()) {

        //loading
        CircularIndeterminateProgressBarComponent(isDisplayed = state.isLoading)

        if(state.isLoading.not() && state.error.isBlank()){
            //content
            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
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
        if (state.isLoading.not() && state.error.isNotBlank()) {
            Text(
                text = state.error,
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

@ExperimentalCoilApi
@Composable
fun CharacterListItem(
    item: CharacterMapper?, onClick: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(200.dp)
            .clickable(onClick = { item?.id?.let { onClick(it) } }),
        shape = RoundedCornerShape(10.dp),
        elevation = 12.dp
    ) {

        Surface(
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(12.dp))
        ) {
            //Coil Image
            Image(
                painter = rememberImagePainter(item?.image),
                contentDescription = stringResource(id = R.string.character_item),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(10.dp))
            )

            Column(
                modifier = Modifier
                    .height(30.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Surface(
                    color = Color.Black.copy(alpha = 0.7f),
                    modifier = Modifier
                        .height(30.dp),
                ) {
                    Text(
                        text = item?.name ?: "",
                        modifier = Modifier
                            .fillMaxWidth(),
                        maxLines = 1,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

            }

        }

    }
}

