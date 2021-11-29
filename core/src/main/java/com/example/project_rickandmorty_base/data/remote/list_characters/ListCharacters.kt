package com.example.project_rickandmorty_base.data.remote.list_characters

import com.example.project_rickandmorty_base.data.remote.character_detail.Character
import com.example.project_rickandmorty_base.data.remote.character_detail.toCharacter
import com.example.project_rickandmorty_base.domain.model.list_characters.ListCharactersMapper

data class ListCharacters(
    val info: Info,
    val results: List<Character>
)

fun ListCharacters.toListCharacter() = ListCharactersMapper(
    infoRemote = info.toInfo(),
    results = results.map { it.toCharacter() }
)