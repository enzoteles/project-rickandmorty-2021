package com.example.project_rickandmorty_base.domain.repository

import com.example.project_rickandmorty_base.data.remote.character_detail.Character
import com.example.project_rickandmorty_base.data.remote.list_characters.ListCharacters
import retrofit2.Response

interface CharacterRepository {

    suspend fun getCharacterDetail(characterId: Int): Response<Character>
    suspend fun getListCharacters(): Response<ListCharacters>
    suspend fun getCharactersPage(pageIndex: Int): Response<ListCharacters>
    suspend fun getCharacterFilter(
        name: String?,
        status: String?,
        species: String?,
        type: String?,
        gender: String?
    ): Response<ListCharacters>
}