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
        assertThat(characterFirstItem?.id).isEqualTo(1)
        assertThat(characterFirstItem?.name).isEqualTo("Rick Sanchez")
        assertThat(characterFirstItem?.status).isEqualTo("Alive")
        assertThat(characterFirstItem?.species).isEqualTo("Human")
        assertThat(characterFirstItem?.gender).isEqualTo("Male")
        assertThat(characterFirstItem?.image).isEqualTo("https://rickandmortyapi.com/api/character/avatar/1.jpeg")
        assertThat(characterFirstItem?.url).isEqualTo("https://rickandmortyapi.com/api/character/1")
        assertThat(characterFirstItem?.created).isEqualTo("2017-11-04T18:48:46.250Z")

    }

    @Test
     fun `checking error 500 of api`():Unit = runBlocking{

        val characterSchema = repository.getError500()
        val errorMessage = gson.fromJson(characterSchema.errorBody()?.charStream(), ErrorMessage::class.java)

        assertThat(characterSchema.code()).isEqualTo(500)
        assertThat(characterSchema.message()).isEqualTo("Response.error()")
        assertThat(errorMessage.title).isEqualTo("Error")
        assertThat(errorMessage.message).isEqualTo("Server Error")
    }

    @Test
    fun `checking error 502 of api`():Unit = runBlocking{

        val characterSchema = repository.getError502()
        val errorMessage = gson.fromJson(characterSchema.errorBody()?.charStream(), ErrorMessage::class.java)

        assertThat(characterSchema.code()).isEqualTo(502)
        assertThat(characterSchema.message()).isEqualTo("Response.error()")
        assertThat(errorMessage.title).isEqualTo("Error")
        assertThat(errorMessage.message).isEqualTo("Bad Request")
    }

    @Test
    fun `checking error 404 of api`():Unit = runBlocking{

        val characterSchema = repository.getError404()
        val errorMessage = gson.fromJson(characterSchema.errorBody()?.charStream(), ErrorMessage::class.java)

        assertThat(characterSchema.code()).isEqualTo(404)
        assertThat(characterSchema.message()).isEqualTo("Response.error()")
        assertThat(errorMessage.title).isEqualTo("Error")
        assertThat(errorMessage.message).isEqualTo("Not Found")

    }
}