package com.example.project_rickandmorty_base.presentation.ui.components.list_characters

import com.example.project_rickandmorty_base.domain.model.list_characters.ListCharactersMapper

data class GetListCharactersState(
    val isLoadding: Boolean = false,
    val data: ListCharactersMapper?= null,
    val error: String = ""
)


