package com.example.project_rickandmorty_base.domain.model.list_characters

import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper

data class ListCharactersMapper(
    val infoRemote: InfoMapper = InfoMapper(),
    val results: List<CharacterMapper> = listOf()
)