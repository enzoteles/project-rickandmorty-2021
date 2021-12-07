package com.example.project_rickandmorty_base.presentation.ui.screen.filter_character

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper
import com.example.project_rickandmorty_base.presentation.ui.viewmodel.filter_character.GetFilterCharactersViewModel

@ExperimentalCoilApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun BottomSheetCharacterScreen(
    viewModel: GetFilterCharactersViewModel = hiltViewModel(),
    onclick: () -> Unit,
) {
    val name  by  viewModel.name.observeAsState("")
    val status by viewModel.status.observeAsState("")
    val species by viewModel.species.observeAsState("")
    val type by  viewModel.type.observeAsState("")
    val gender by viewModel.gender.observeAsState("")

    Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            Column {

                OutlinedTextField(
                    value = name,
                    onValueChange = { viewModel.onNameChange(it) },
                    label = { Text("Nome") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = status,
                    onValueChange = { viewModel.onStatusChange(it) },
                    label = { Text("Status") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = species,
                    onValueChange = { viewModel.onSpeciesChange(it) },
                    label = { Text("Espécie") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = type,
                    onValueChange = { viewModel.onTypeChange(it) },
                    label = { Text("Tipo") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = gender,
                    onValueChange = { viewModel.onGenderChange(it) },
                    label = { Text("Sexo") },
                    modifier = Modifier.fillMaxWidth()
                )

            }

            Button(
                onClick = {
                    onclick()
                          },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .fillMaxWidth()
            ) {
                // Inner content including an icon and a text label
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(
                    text = "Like",
                    fontSize = 18.sp
                    )
            }
    }
}


