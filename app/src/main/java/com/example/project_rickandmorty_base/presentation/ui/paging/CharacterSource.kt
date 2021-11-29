package com.example.project_rickandmorty_base.presentation.ui.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.project_rickandmorty_base.data.datasource.RickAndMortkDataSource
import com.example.project_rickandmorty_base.data.remote.character_detail.toCharacter
import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper
import com.example.project_rickandmorty_base.domain.repository.CharacterRepository
import com.example.project_rickandmorty_base.presentation.di.AppModule
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CharacterSource @Inject constructor(
    private val api: RickAndMortkDataSource
): PagingSource<Int, CharacterMapper>() {

    override fun getRefreshKey(state: PagingState<Int, CharacterMapper>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterMapper> {
        Log.i("page", "${params.key}")
        return try {
            val nextPage = params.key ?: 1
            api.getCharactersPage(pageIndex = nextPage).let { characterList->
                LoadResult.Page(
                    data = characterList.body()?.results?.map { it.toCharacter() } ?: listOf(),
                    prevKey = if(nextPage == 1) null else nextPage - 1,
                    nextKey = if(characterList.body()?.results == null) null else characterList.body()?.info?.pages?.let { p-> p+1 }
                )
            }

        }catch (e: HttpException){
            return LoadResult.Error(e)
        }catch (e: IOException){
            return LoadResult.Error(e)
        }
    }
}

