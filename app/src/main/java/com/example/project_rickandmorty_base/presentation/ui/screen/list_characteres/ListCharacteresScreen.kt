package com.example.project_rickandmorty_base.presentation.ui.screen.list_characteres

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper
import com.example.project_rickandmorty_base.presentation.ui.components.list_characters.GetListCharactersState
import com.example.project_rickandmorty_base.presentation.ui.screen.Screen
import com.example.project_rickandmorty_base.presentation.ui.viewmodel.list_characteres.GetListCharactersViewModel

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

@Composable
fun ListCharacterLazyCollun(state: GetListCharactersState, nameScreen: (String) -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        //loading
        if(state.isLoadding) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        //content
        LazyColumn{
            itemsIndexed(
                state.data?.results ?: listOf()
            ){ index, item ->
                // layout character item
                CharacterListItem(item = item, onClick = {
                    nameScreen(Screen.CharacterDetailScreen.route + "/$index")
                })
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

@Composable
fun CharacterListItem(item: CharacterMapper, onClick: () -> Unit) {
    Log.i("result", "$item")
    Log.i("result", "$item")
}
