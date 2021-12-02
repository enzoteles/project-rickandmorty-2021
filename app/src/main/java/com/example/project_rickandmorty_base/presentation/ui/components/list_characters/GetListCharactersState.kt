package com.example.project_rickandmorty_base.presentation.ui.components.list_characters

import com.example.project_rickandmorty_base.data.remote.list_characters.ListCharacters
import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper
import com.example.project_rickandmorty_base.domain.model.list_characters.ListCharactersMapper

data class GetListCharactersState(
    val isLoading: Boolean = true,
    val data: List<CharacterMapper>? = listOf(),
    val error: String = ""
)


