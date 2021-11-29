package com.example.project_rickandmorty_base.presentation.ui.viewmodel.list_characteres

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project_rickandmorty_base.commons.components.ApiResponse
import com.example.project_rickandmorty_base.data.remote.list_characters.toListCharacter
import com.example.project_rickandmorty_base.domain.usecase.GetListCharactersUseCase
import com.example.project_rickandmorty_base.presentation.ui.components.list_characters.GetListCharactersState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GetListCharactersViewModel @Inject constructor(
    private val getListCharactersUseCase: GetListCharactersUseCase
): ViewModel() {

    private var _state = mutableStateOf(GetListCharactersState())
    val state: State<GetListCharactersState> = _state

    init {
        getListCharacters()
    }

    fun getListCharacters() {
        getListCharactersUseCase.invoke().onEach { result ->

            when (result) {
                is ApiResponse.Loading -> {
                    _state.value = GetListCharactersState(
                        isLoadding = true
                    )
                }
                is ApiResponse.Success -> {
                    _state.value = GetListCharactersState(
                        data = result.data?.toListCharacter()
                    )
                }
                is ApiResponse.Failure -> {
                        _state.value = GetListCharactersState(
                            error = result.msg
                        )
                }

            }
        }.launchIn(viewModelScope)

    }
}