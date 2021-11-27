package com.example.project_rickandmorty_base.presentation.di

import com.example.project_rickandmorty_base.data.repository.CharacterRepositoryImpl
import com.example.project_rickandmorty_base.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface CharacterModule {

    @Binds
    fun bindGetCommicsRepository(repository: CharacterRepositoryImpl): CharacterRepository
}