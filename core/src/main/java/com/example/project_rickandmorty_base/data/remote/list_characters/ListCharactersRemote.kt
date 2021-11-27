package com.example.project_rickandmorty_base.data.remote.list_characters

import com.example.project_rickandmorty_base.data.remote.character_detail.CharacterRemote
import com.example.project_rickandmorty_base.data.remote.character_detail.toCharacter
import com.example.project_rickandmorty_base.domain.model.list_characters.ListCharactersMapper

data class ListCharactersRemote(
    val infoRemote: InfoRemote,
    val results: List<CharacterRemote>
)

fun ListCharactersRemote.toListCharacter() = ListCharactersMapper(
    infoRemote = infoRemote.toInfo(),
    results = results.map { it.toCharacter() }
)