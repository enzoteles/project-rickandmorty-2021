package com.example.project_rickandmorty_base.data

import com.example.project_rickandmorty_base.data.remote.character_detail.CharacterRemote
import com.example.project_rickandmorty_base.data.remote.list_characters.ListCharactersRemote
import com.example.project_rickandmorty_base.domain.repository.CharacterRepository
import retrofit2.Response

class FakeCharacterRepository: CharacterRepository{

    override suspend fun getCharacterDetail(characterId: Int): Response<CharacterRemote> {
        return Response.success(CharacterRemoteTest.characterById)
    }

    override suspend fun getListCharacters(): Response<ListCharactersRemote> {
        return Response.success(CharacterRemoteTest.listCharacter)
    }

    override suspend fun getCharactersPage(pageIndex: Int): Response<ListCharactersRemote> {
        return Response.success(CharacterRemoteTest.listCharacter)
    }

    override suspend fun getCharacterFilter(
        name: String?,
        status: String?,
        species: String?,
        type: String?,
        gender: String?
    ): Response<ListCharactersRemote> {
        return Response.success(CharacterRemoteTest.listCharacter)
    }

}