package com.example.project_rickandmorty_base.presentation.ui.components.list_characters

import androidx.paging.PagingData
import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper
import kotlinx.coroutines.flow.Flow

data class GetListCharactersState(
    val isLoadding: Boolean = false,
    val data: Flow<PagingData<CharacterMapper>> ?= null,
    val error: String = ""
)


