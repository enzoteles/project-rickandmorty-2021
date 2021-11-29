package com.example.project_rickandmorty_base.data

import com.example.project_rickandmorty_base.data.remote.character_detail.CharacterRemote
import com.example.project_rickandmorty_base.data.remote.list_characters.ListCharactersRemote
import com.example.project_rickandmorty_base.domain.repository.CharacterRepository
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response

class FakeCharacterRepository: CharacterRepository{

    val listCharacterResponse = Gson().fromJson(ClassLoader.getSystemResource("character/listCharacters.json").readText(), ListCharactersRemote::class.java)
    val character = Gson().fromJson(ClassLoader.getSystemResource("character/listCharacters.json").readText(), CharacterRemote::class.java)

    override suspend fun getCharacterDetail(characterId: Int): Response<CharacterRemote> {
        return Response.success(character)
    }

    override suspend fun getListCharacters(): Response<ListCharactersRemote> {
        return Response.success(listCharacterResponse)
    }

    override suspend fun getCharactersPage(pageIndex: Int): Response<ListCharactersRemote> {
        return Response.success(listCharacterResponse)
    }

    override suspend fun getCharacterFilter(
        name: String?,
        status: String?,
        species: String?,
        type: String?,
        gender: String?
    ): Response<ListCharactersRemote> {
        return Response.success(listCharacterResponse)
    }

}