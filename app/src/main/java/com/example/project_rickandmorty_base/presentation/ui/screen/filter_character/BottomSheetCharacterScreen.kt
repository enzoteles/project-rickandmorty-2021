package com.example.project_rickandmorty_base.presentation.ui.screen.filter_character

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.example.project_rickandmorty_base.R
import com.example.project_rickandmorty_base.commons.utils.Constants
import com.example.project_rickandmorty_base.commons.utils.TestTags
import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper
import com.example.project_rickandmorty_base.presentation.ui.components.topbar.MenuAction
import com.example.project_rickandmorty_base.presentation.ui.viewmodel.filter_character.GetFilterCharactersViewModel

@ExperimentalCoilApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun BottomSheetCharacterScreen(
    viewModel: GetFilterCharactersViewModel,
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag(TestTags.BS_NAME_TEXT_FIELD),
                    trailingIcon = {Icon(Icons.Filled.Clear,
                        contentDescription = "clear text",
                        modifier = Modifier
                            .offset(x= 10.dp)
                            .padding(end = 10.dp)
                            .clickable {
                                viewModel.onNameChange("")
                            }
                    )}
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = status,
                    onValueChange = { viewModel.onStatusChange(it) },
                    label = { Text("Status") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag(TestTags.BS_STATUS_TEXT_FIELD),
                    trailingIcon = {Icon(Icons.Filled.Clear,
                        contentDescription = "clear text",
                        modifier = Modifier
                            .offset(x= 10.dp)
                            .padding(end = 10.dp)
                            .clickable {
                                viewModel.onStatusChange("")
                            }
                    )}
                )

                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = species,
                    onValueChange = { viewModel.onSpeciesChange(it) },
                    label = { Text("Espécie") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag(TestTags.BS_SPECIES_TEXT_FIELD),
                    trailingIcon = {Icon(Icons.Filled.Clear,
                        contentDescription = "clear text",
                        modifier = Modifier
                            .offset(x= 10.dp)
                            .padding(end = 10.dp)
                            .clickable {
                                viewModel.onSpeciesChange("")
                            }
                    )}
                )

                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = type,
                    onValueChange = { viewModel.onTypeChange(it) },
                    label = { Text("Tipo") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag(TestTags.BS_TYPE_TEXT_FIELD),
                    trailingIcon = {Icon(Icons.Filled.Clear,
                        contentDescription = "clear text",
                        modifier = Modifier
                            .offset(x= 10.dp)
                            .padding(end = 10.dp)
                            .clickable {
                                viewModel.onTypeChange("")
                            }
                    )}
                )

                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = gender,
                    onValueChange = { viewModel.onGenderChange(it) },
                    label = { Text("Sexo") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag(TestTags.BS_GENDER_TEXT_FIELD),
                    trailingIcon = {Icon(Icons.Filled.Clear,
                        contentDescription = "clear text",
                        modifier = Modifier
                            .offset(x= 10.dp)
                            .padding(end = 10.dp)
                            .clickable {
                            viewModel.onGenderChange("")
                        }
                    )}
                )

            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp)
                    .align(Alignment.BottomEnd)
                    ){

                Button(
                    onClick = {
                        viewModel.cleanAllFilter()
                    },
                    modifier = Modifier
                        .weight(5.0f, true)
                        .fillMaxWidth()
                        .testTag(TestTags.BTN_BOTTOM_SHEET_CHARACTER_CLEAN),
                ) {

                    Text(
                        text = stringResource(id = R.string.btn_clean_character),
                        fontSize = 18.sp
                    )
                }

                Button(
                    onClick = {
                        viewModel.getListCharactersFilter()
                        onclick()
                    },
                    modifier = Modifier
                        .weight(5.0f, true)
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                        .testTag(TestTags.BTN_BOTTOM_SHEET_CHARACTER_FILTER),
                ) {

                    Text(
                        text = stringResource(id = R.string.btn_filter_character),
                        fontSize = 18.sp
                    )
                }
            }

    }
}


