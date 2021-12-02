package com.example.project_rickandmorty_base.presentation.ui.screen.character_detail

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.project_rickandmorty_base.R
import com.example.project_rickandmorty_base.commons.utils.TestTags
import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper
import com.example.project_rickandmorty_base.presentation.ui.components.GenericsGetState
import com.example.project_rickandmorty_base.presentation.ui.screen.list_characteres.ListCharacterLazyCollun
import com.example.project_rickandmorty_base.presentation.ui.screen.list_characteres.TopBarListCharacter
import com.example.project_rickandmorty_base.presentation.ui.viewmodel.character_detail.GetCharacterDetailViewModel
import com.example.project_rickandmorty_base.presentation.ui.viewmodel.list_characteres.GetListCharactersViewModel

@ExperimentalCoilApi
@Composable
fun CharacterDetailScreen(
    viewModel: GetCharacterDetailViewModel = hiltViewModel(),
    onClick: () -> Unit
) {
    Scaffold(
        topBar = { TopBarLCharacterDetail(onClick) },
        content = {
            CharacterDetailContent(viewModel)
        },
    )

}

@Composable
fun TopBarLCharacterDetail(
    onClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.detail_screen),
                modifier = Modifier.testTag(TestTags.TITLE_CHARACTER_DETAIL_BAR))
        },
        navigationIcon = {
            IconButton(
                onClick = { onClick() },
            modifier = Modifier.testTag(TestTags.BUTTON_CHARACTER_TOP_BAR_BACK)) {
                Icon(Icons.Filled.ArrowBack,"")
            }
        },

        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 12.dp
    )
}

@Composable
fun CharacterDetailContent(viewModel: GetCharacterDetailViewModel) {

    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        state.data?.let { character ->
            LazyColumn(
                modifier = Modifier.fillMaxSize()){
                item {
                    Image(
                        painter = rememberImagePainter(character.image),
                        contentDescription = "Character Item",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Column(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(start = 8.dp, end = 8.dp)
                    ) {
                        Text(
                            text = character.name,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp)
                        )
                        Divider()

                        Spacer(modifier = Modifier.height(25.dp))
                        Row {
                            Text(
                                text = "Status: ",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                            )
                            Text(
                                text = "${character.status}",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black,
                            )
                        }

                        Spacer(modifier = Modifier.height(25.dp))
                        Row {
                            Text(
                                text = "Species: ",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                            )
                            Text(
                                text = "${character.species}",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black,
                            )
                        }

                        Spacer(modifier = Modifier.height(25.dp))
                        Row {
                            Text(
                                text = "Gender: ",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                            )
                            Text(
                                text = "${character.species}",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black,
                            )
                        }

                        Spacer(modifier = Modifier.height(25.dp))
                        Row {
                            Text(
                                text = "Url: ",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                            )
                            Text(
                                text = "${character.url}",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black,
                            )
                        }

                        Spacer(modifier = Modifier.height(25.dp))
                        Row {
                            Text(
                                text = "Created: ",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                            )
                            Text(
                                text = "${character.created}",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black,
                            )
                        }
                    }
                }
            }
        }
    }

}

