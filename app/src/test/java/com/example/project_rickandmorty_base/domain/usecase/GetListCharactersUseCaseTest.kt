package com.example.project_rickandmorty_base.domain.usecase

import com.example.project_rickandmorty_base.commons.components.ApiResponse
import com.example.project_rickandmorty_base.data.ErrorMessage
import com.example.project_rickandmorty_base.data.FakeCharacterRepository
import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import java.io.InputStreamReader

class GetListCharactersUseCaseTest{

    lateinit var repository: FakeCharacterRepository
    lateinit var useCase: GetListCharactersUseCase
    lateinit var gson: Gson

    @Before
    fun setUp(){
        repository = FakeCharacterRepository()
        useCase = GetListCharactersUseCase(repository)
        gson = Gson()
    }

    @Test
    fun `checking the api status`(): Unit = runBlocking {
        useCase.invoke().onEach { result ->
            when(result){
                is ApiResponse.Loading->{
                    assertThat(true).isTrue()
                }
                is ApiResponse.Success->{
                    assertThat(true).isTrue()
                }
                is ApiResponse.Failure -> {
                    assertThat(true).isTrue()
                }
            }
        }
    }

    @Test
    fun `checking status 200 of api`(): Unit = runBlocking {

        val characterSchema = repository.getListCharacters()
        val characterFirstItem = characterSchema.body()?.results?.first()

        assertThat(characterSchema.code()).isEqualTo(200)
        assertThat(characterSchema.message()).isEqualTo("OK")

        assertThat(characterFirstItem?.id).isEqualTo(2)
        assertThat(characterFirstItem?.name).isEqualTo("Morty Smith")
        assertThat(characterFirstItem?.status).isEqualTo("Alive")
        assertThat(characterFirstItem?.species).isEqualTo("Human")
        assertThat(characterFirstItem?.gender).isEqualTo("Male")

        assertThat(characterFirstItem?.originRemote?.name).isEqualTo("Earth")
        assertThat(characterFirstItem?.originRemote?.url).isEqualTo("https://rickandmortyapi.com/api/location/1")

        assertThat(characterFirstItem?.locationRemote?.name).isEqualTo("Earth")
        assertThat(characterFirstItem?.locationRemote?.url).isEqualTo("https://rickandmortyapi.com/api/location/2")

        assertThat(characterFirstItem?.image).isEqualTo("https://rickandmortyapi.com/api/character/avatar/2.jpeg")
        assertThat(characterFirstItem?.url).isEqualTo("https://rickandmortyapi.com/api/character/2")
        assertThat(characterFirstItem?.created).isEqualTo("created\": \"2017-11-04T18:50:21.651Z")

    }

    @Test
     fun `checking error 500 of api`():Unit = runBlocking{

        val error = repository.getError500()
        val errorMessage = gson.fromJson(InputStreamReader(error.errorBody()?.byteStream()), ErrorMessage::class.java)

        assertThat(error.code()).isEqualTo(500)
        assertThat(error.message()).isEqualTo("Response.error()")
        assertThat(errorMessage.message).isEqualTo("Server Error")
    }

    @Test
    fun `checking error 502 of api`():Unit = runBlocking{

        val error = repository.getError502()
        val errorMessage = gson.fromJson(InputStreamReader(error.errorBody()?.byteStream()), ErrorMessage::class.java)

        assertThat(error.code()).isEqualTo(502)
        assertThat(error.message()).isEqualTo("Response.error()")
        assertThat(errorMessage.message).isEqualTo("Bad Request")
    }

    @Test
    fun `checking error 404 of api`():Unit = runBlocking{

        val error = repository.getError404()
        val errorMessage = gson.fromJson(InputStreamReader(error.errorBody()?.byteStream()), ErrorMessage::class.java)

        assertThat(error.code()).isEqualTo(404)
        assertThat(error.message()).isEqualTo("Response.error()")
        assertThat(errorMessage.message).isEqualTo("Not Found")
    }

}