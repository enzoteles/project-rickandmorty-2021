package com.example.project_rickandmorty_base.presentation.di

import androidx.paging.PagingSource
import com.example.project_rickandmorty_base.data.datasource.RickAndMortkDataSource
import com.example.project_rickandmorty_base.data.repository.CharacterRepositoryImpl
import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper
import com.example.project_rickandmorty_base.domain.repository.CharacterRepository
import com.example.project_rickandmorty_base.domain.usecase.*
import com.example.project_rickandmorty_base.presentation.ui.paging.CharacterSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface CharacterModule {

    @Binds
    fun bindCharacterRepository(repository: CharacterRepositoryImpl): CharacterRepository

    @Binds
    fun bindGetListCharactersUseCase(useCase: GetListCharactersUseCaseImpl): GetListCharactersUseCase

    @Binds
    fun bindGetCharacterDetailUseCase(useCase: GetCharacterDetailUseCaseImpl): GetCharacterDetailUseCase

    @Binds
    fun bindGetCharacterFilterUseCase(useCase: GetCharacterFilterUseCaseImpl): GetCharacterFilterUseCase

}