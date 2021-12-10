package com.example.project_rickandmorty_base.domain.model.list_characters

import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper
import java.io.Serializable

data class ListCharactersMapper(
    val infoRemote: InfoMapper = InfoMapper(),
    val results: List<CharacterMapper> = listOf()
)