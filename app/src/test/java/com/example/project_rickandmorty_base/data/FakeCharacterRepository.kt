package com.example.project_rickandmorty_base.data

import com.example.project_rickandmorty_base.data.remote.character_detail.Character
import com.example.project_rickandmorty_base.data.remote.list_characters.ListCharacters
import com.example.project_rickandmorty_base.domain.repository.CharacterRepository
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response

class FakeCharacterRepository: CharacterRepository{

    private val listCharacterResponse = Gson().fromJson(ClassLoader.getSystemResource("character/listCharacters.json").readText(), ListCharacters::class.java)
    private val character = Gson().fromJson(ClassLoader.getSystemResource("character/characterById.json").readText(), Character::class.java)

    override suspend fun getCharacterDetail(characterId: Int): Response<Character> {
        return Response.success(character)
    }

    override suspend fun getListCharacters(): Response<ListCharacters> {
        return Response.success(listCharacterResponse)
    }

    override suspend fun getCharactersPage(pageIndex: Int): Response<ListCharacters> {
        return Response.success(listCharacterResponse)
    }

    override suspend fun getCharacterFilter(
        name: String?,
        status: String?,
        species: String?,
        type: String?,
        gender: String?
    ): Response<ListCharacters> {
        return Response.success(listCharacterResponse)
    }

    suspend fun getError500(): Response<ListCharacters>{
        val errorResponse = ClassLoader.getSystemResource("error/error500.json").readText()
        val errorResponseBody = errorResponse.toResponseBody("application/json".toMediaTypeOrNull())
        return  Response.error(500, errorResponseBody)
    }

    suspend fun getError502(): Response<ListCharacters>{
        val errorResponse = ClassLoader.getSystemResource("error/error502.json").readText()
        val errorResponseBody = errorResponse.toResponseBody("application/json".toMediaTypeOrNull())
        return  Response.error(502, errorResponseBody)
    }

    suspend fun getError404(): Response<ListCharacters>{
        val errorResponse = ClassLoader.getSystemResource("error/error404.json").readText()
        val errorResponseBody = errorResponse.toResponseBody("application/json".toMediaTypeOrNull())
        return  Response.error(404, errorResponseBody)
    }

}