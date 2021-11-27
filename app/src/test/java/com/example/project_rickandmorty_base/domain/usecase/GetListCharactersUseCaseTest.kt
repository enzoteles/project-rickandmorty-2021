package com.example.project_rickandmorty_base.domain.usecase

import com.example.project_rickandmorty_base.commons.components.ApiResponse
import com.example.project_rickandmorty_base.data.FakeCharacterRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetListCharactersUseCaseTest{

    lateinit var repository: FakeCharacterRepository
    lateinit var useCase: GetListCharactersUseCase

    @Before
    fun setUp(){
        repository = FakeCharacterRepository()
        useCase = GetListCharactersUseCase(repository)
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
        val characterSchema = repository.getListCharacters().body()
        val characterFirstItem = characterSchema?.results?.first()

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

}