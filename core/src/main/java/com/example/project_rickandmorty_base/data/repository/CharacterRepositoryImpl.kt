package com.example.project_rickandmorty_base.data.repository

import com.example.project_rickandmorty_base.data.datasource.RickAndMortkDataSource
import com.example.project_rickandmorty_base.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMortkDataSource
): CharacterRepository {

    override suspend fun getCharacterDetail(characterId: Int)
        = api.getCharacterDetail(characterId)


    override suspend fun getListCharacters()
        = api.getListCharacters()


    override suspend fun getCharactersPage(pageIndex: Int)
        = api.getCharactersPage(pageIndex)


    override suspend fun getCharacterFilter(
        name: String?,
        status: String?,
        species: String?,
        type: String?,
        gender: String?
    ) = api.getCharacterFilter(name, status, species, type)
}