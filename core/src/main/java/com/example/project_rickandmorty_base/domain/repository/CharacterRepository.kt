package com.example.project_rickandmorty_base.domain.repository

import com.example.project_rickandmorty_base.data.remote.character_detail.CharacterRemote
import com.example.project_rickandmorty_base.data.remote.list_characters.ListCharactersRemote
import retrofit2.Response

interface CharacterRepository {

    suspend fun getCharacterDetail(characterId: Int): Response<CharacterRemote>
    suspend fun getListCharacters(): Response<ListCharactersRemote>
    suspend fun getCharactersPage(pageIndex: Int): Response<ListCharactersRemote>
    suspend fun getCharacterFilter(
        name: String?,
        status: String?,
        species: String?,
        type: String?,
        gender: String?
    ): Response<ListCharactersRemote>
}