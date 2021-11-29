package com.example.project_rickandmorty_base.presentation.di

import com.example.project_rickandmorty_base.commons.utils.Constants
import com.example.project_rickandmorty_base.data.datasource.RickAndMortkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private fun getLoggingInterceptor() = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BASIC)
    private fun getHttpClient() = OkHttpClient.Builder()
        .addInterceptor(getLoggingInterceptor())
        .build()

    @Provides
    @Singleton
    fun provideMarvelApi(): RickAndMortkDataSource {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getHttpClient())
            .build()
            .create(RickAndMortkDataSource::class.java)
    }
}