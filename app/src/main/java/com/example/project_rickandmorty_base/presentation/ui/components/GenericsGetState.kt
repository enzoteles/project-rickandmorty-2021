package com.example.project_rickandmorty_base.presentation.ui.components

import com.example.project_rickandmorty_base.data.remote.list_characters.ListCharacters
import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper
import com.example.project_rickandmorty_base.domain.model.list_characters.ListCharactersMapper

data class GenericsGetState<T>(
    val isLoading: Boolean = true,
    val data: T ?= null,
    val error: String = ""
)


