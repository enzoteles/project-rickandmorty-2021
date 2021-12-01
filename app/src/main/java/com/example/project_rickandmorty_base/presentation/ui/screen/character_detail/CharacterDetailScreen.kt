package com.example.project_rickandmorty_base.presentation.ui.screen.character_detail

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper
import com.example.project_rickandmorty_base.presentation.ui.components.GenericsGetState
import com.example.project_rickandmorty_base.presentation.ui.viewmodel.character_detail.GetCharacterDetailViewModel
import com.example.project_rickandmorty_base.presentation.ui.viewmodel.list_characteres.GetListCharactersViewModel

@Composable
fun CharacterDetailScreen(
    viewModel: GetCharacterDetailViewModel = hiltViewModel()
    ) {

    val ret = viewModel.state.value
    Log.i("item", "${ret.data}")
    Log.i("item", "${ret.data}")
}