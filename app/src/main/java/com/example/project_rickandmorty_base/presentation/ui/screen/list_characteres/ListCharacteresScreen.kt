package com.example.project_rickandmorty_base.presentation.ui.screen.list_characteres

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper
import com.example.project_rickandmorty_base.presentation.ui.components.list_characters.GetListCharactersState
import com.example.project_rickandmorty_base.presentation.ui.screen.Screen
import com.example.project_rickandmorty_base.presentation.ui.viewmodel.list_characteres.GetListCharactersViewModel
import kotlinx.coroutines.flow.Flow

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun ListCharacterScreen(
    viewModel: GetListCharactersViewModel,
    nameScreen: (String) -> Unit
) {
    val state = viewModel.state.value
    val dataSource = viewModel.character
    Scaffold(
        topBar = { TopBarListCharacter() },
        content = { ListCharacterLazyCollun(dataSource = dataSource, state = state, nameScreen = nameScreen) },
    )

}

@Composable
fun TopBarListCharacter() {
    TopAppBar(
        title = {
            Text(text = "List of Characters")
        },

        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 12.dp
    )
}


@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun ListCharacterLazyCollun(
    dataSource: Flow<PagingData<CharacterMapper>>,
    state: GetListCharactersState,
    nameScreen: (String) -> Unit
) {
    val characterListItem: LazyPagingItems<CharacterMapper> = dataSource.collectAsLazyPagingItems()

    Box(modifier = Modifier.fillMaxSize()) {
        //loading
        if (state.isLoadding) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        //content
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp)
        ){
            items(characterListItem.itemCount){ index->
                val character = characterListItem[index]
                CharacterListItem(character) {
                    nameScreen(Screen.CharacterDetailScreen.route + "/$character.id")
                }
            }
        }

        //error
        if (state.error.isNotBlank()) {
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
fun CharacterListItem(item: CharacterMapper?, onClick: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(200.dp),
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
                contentDescription = null,
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

