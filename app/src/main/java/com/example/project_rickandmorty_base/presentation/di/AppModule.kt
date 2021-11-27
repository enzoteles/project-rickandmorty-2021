package com.example.project_rickandmorty_base.presentation.di

import com.example.project_rickandmorty_base.commons.utils.Constants
import com.example.project_rickandmorty_base.data.datasource.RickAndMortkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMarvelApi(): RickAndMortkDataSource {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortkDataSource::class.java)
    }
}