package com.example.project_rickandmorty_base.data.datasource

import com.example.project_rickandmorty_base.data.remote.character_detail.Character
import com.example.project_rickandmorty_base.data.remote.list_characters.ListCharacters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortkDataSource {

    @GET("character/{character-id}")
    suspend fun getCharacterDetail(
        @Path("character-id") characterId: Int
    ): Response<Character>

    @GET("character")
    suspend fun getListCharacters(
    ): Response<ListCharacters>

    @GET("character")
    suspend fun getCharactersPage(
        @Query("page") pageIndex: Int
    ): Response<ListCharacters>

    @GET("character/")
    suspend fun getCharacterFilter(
        @Query("name") name: String? = "",
        @Query("status") status: String?= "",
        @Query("species") species: String?="",
        @Query("type") type: String?="",
        @Query("gender") gender: String?="",
    ): Response<ListCharacters>

}