package com.example.project_rickandmorty_base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper
import com.example.project_rickandmorty_base.presentation.ui.components.list_characters.GetListCharactersState
import com.example.project_rickandmorty_base.presentation.ui.screen.MainNavGraph
import com.example.project_rickandmorty_base.presentation.ui.screen.Screen
import com.example.project_rickandmorty_base.presentation.ui.viewmodel.list_characteres.GetListCharactersViewModel
import com.example.projeto_marvel.presentation.ui.theme.ProjetoRickAndMorkTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetoRickAndMorkTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainNavGraph()
                }
            }
        }
    }
}



@ExperimentalFoundationApi
@Composable
fun ListCharacterScreen(
    viewModel: GetListCharactersViewModel,
    nameScreen: (String)-> Unit
){
    val state = viewModel.state.value
    Scaffold(
        topBar = { TopBarListCharacter() },
        content = { ListCharacterLazyCollun(state = state, nameScreen = nameScreen) },
    )

}

@Composable
fun TopBarListCharacter(){
    TopAppBar(
        title = {
            Text(text = "List of Characters")
        },

        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 12.dp
    )
}


@ExperimentalFoundationApi
@Composable
fun ListCharacterLazyCollun(state: GetListCharactersState, nameScreen: (String) -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        //loading
        if(state.isLoadding) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        //content
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(state.data?.results ?: listOf()){ item->
                CharacterListItem(item){
                    nameScreen(Screen.CharacterDetailScreen.route + "/$item.id")
                }
            }
        }
        //error
        if(state.error.isNotBlank()) {
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
fun CharacterListItem(item: CharacterMapper, onClick: (String) -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth())
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
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
                painter = rememberImagePainter(item.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
        }

    }
}

