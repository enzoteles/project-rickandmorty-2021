package com.example.project_rickandmorty_base.data.datasource

import com.example.project_rickandmorty_base.data.remote.character_detail.CharacterRemote
import com.example.project_rickandmorty_base.data.remote.list_characters.ListCharactersRemote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortkDataSource {

    @GET("character/{character-id}")
    suspend fun getCharacterDetail(
        @Path("character-id") characterId: Int
    ): Response<CharacterRemote>

    @GET("character")
    suspend fun getListCharacters(
    ): Response<ListCharactersRemote>

    @GET("character")
    suspend fun getCharactersPage(
        @Query("page") pageIndex: Int
    ): Response<ListCharactersRemote>

    @GET("character/")
    suspend fun getCharacterFilter(
        @Query("name") name: String?= null,
        @Query("status") status: String?= null,
        @Query("species") species: String?=null,
        @Query("type") type: String?=null,
        @Query("gender") gender: String?=null,
    ): Response<ListCharactersRemote>

}