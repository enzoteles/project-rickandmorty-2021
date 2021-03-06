package com.example.project_rickandmorty_base.presentation.ui.viewmodel.list_characteres

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.project_rickandmorty_base.commons.components.ApiResponse
import com.example.project_rickandmorty_base.data.datasource.RickAndMortkDataSource
import com.example.project_rickandmorty_base.data.remote.character_detail.toCharacter
import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper
import com.example.project_rickandmorty_base.domain.usecase.GetListCharactersUseCase
import com.example.project_rickandmorty_base.domain.usecase.GetListCharactersUseCaseImpl
import com.example.project_rickandmorty_base.presentation.ui.components.GenericsUiState
import com.example.project_rickandmorty_base.presentation.ui.paging.CharacterSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GetListCharactersViewModel @Inject constructor(
    private val getListCharactersUseCase: GetListCharactersUseCase,
    private val api: RickAndMortkDataSource,
): ViewModel() {

    private var _state = mutableStateOf(GenericsUiState<List<CharacterMapper>>(isLoading = true))
    val state: State<GenericsUiState<List<CharacterMapper>>> = _state

    val character: Flow<PagingData<CharacterMapper>> = Pager(PagingConfig(pageSize = 10)) {
        CharacterSource(api)
    }.flow.cachedIn(viewModelScope)

    init {
        getListCharacters()
    }

    private fun getListCharacters() {
        getListCharactersUseCase.invoke().onEach { result ->
            delay(1000)
            when (result) {
                is ApiResponse.Loading -> {
                    _state.value = GenericsUiState(
                        isLoading = true
                    )
                }
                is ApiResponse.Success -> {
                    _state.value = GenericsUiState(
                        isLoading = false,
                        data = result.data?.results?.map { it.toCharacter() },
                        error = ""
                    )
                }
                is ApiResponse.Failure -> {
                        _state.value = GenericsUiState(
                            isLoading = false,
                            error = result.msg
                        )
                }

            }
        }.launchIn(viewModelScope)

    }
}