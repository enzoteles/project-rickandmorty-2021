package com.example.project_rickandmorty_base.data

import com.example.project_rickandmorty_base.data.remote.character_detail.CharacterRemote
import com.example.project_rickandmorty_base.data.remote.character_detail.LocationRemote
import com.example.project_rickandmorty_base.data.remote.character_detail.OriginRemote
import com.example.project_rickandmorty_base.data.remote.list_characters.InfoRemote
import com.example.project_rickandmorty_base.data.remote.list_characters.ListCharactersRemote
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response

object CharacterRemoteTest {

    val characterById = CharacterRemote(
        id = 2,
        name = "Morty Smith",
        status = "Alive",
        species = "Human",
        type = "",
        gender = "Male",
        originRemote = OriginRemote(
            name = "Earth",
            url = "https://rickandmortyapi.com/api/location/1"
        ),
        locationRemote = LocationRemote(
            name = "Earth",
            url = "https://rickandmortyapi.com/api/location/2"
        ),
        image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
        episode = listOf(),
        url = "https://rickandmortyapi.com/api/character/2",
        created = "created\": \"2017-11-04T18:50:21.651Z"
    )

    val listCharacter = ListCharactersRemote(
        infoRemote = InfoRemote(
            count = 826,
            pages = 42,
            next = "https://rickandmortyapi.com/api/character/?page=2",
        ),
        results = listOf(characterById)
    )

    suspend fun getError500(): Response<ListCharactersRemote> {
        val errorResponse =
            " {\n" +
                    " \"title\": \"error\",\n"+
                    " \"message\": \"Server Error\"\n"+
                    "}"

        val errorResponseBody = errorResponse.toResponseBody("application/json".toMediaTypeOrNull())
        return Response.error(
            500,
            errorResponseBody
        )
    }

    suspend fun getError404(): Response<ListCharactersRemote> {
        val errorResponse =
            " {\n" +
                    " \"title\": \"error\",\n"+
                    " \"message\": \"Not Found\"\n"+
                    "}"

        val errorResponseBody = errorResponse.toResponseBody("application/json".toMediaTypeOrNull())
        return Response.error(
            404,
            errorResponseBody
        )
    }

    suspend fun getError502(): Response<ListCharactersRemote> {
        val errorResponse =
            " {\n" +
                    " \"title\": \"error\",\n"+
                    " \"message\": \"Bad Request\"\n"+
                    "}"

        val errorResponseBody = errorResponse.toResponseBody("application/json".toMediaTypeOrNull())
        return Response.error(
            502,
            errorResponseBody
        )
    }


}