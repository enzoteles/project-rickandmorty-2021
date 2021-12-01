package com.example.project_rickandmorty_base.presentation.ui.viewmodel.character_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project_rickandmorty_base.commons.components.ApiResponse
import com.example.project_rickandmorty_base.commons.utils.Constants
import com.example.project_rickandmorty_base.data.remote.character_detail.toCharacter
import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper
import com.example.project_rickandmorty_base.domain.usecase.GetCharacterDetailUseCase
import com.example.project_rickandmorty_base.presentation.ui.components.GenericsGetState
import com.example.project_rickandmorty_base.presentation.ui.components.list_characters.GetListCharactersState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GetCharacterDetailViewModel @Inject constructor(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase,
      savedStateHandle: SavedStateHandle
): ViewModel() {

    private var _state = mutableStateOf(GenericsGetState<CharacterMapper>())
    val state: State<GenericsGetState<CharacterMapper>> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_CHARACTER_ID)?.let { characterId ->
            getDetailCharacter(characterId)
        }
    }

    private fun getDetailCharacter(characterId: String) {
        getCharacterDetailUseCase.invoke(characterId.toInt()).onEach { result ->

            when (result) {
                is ApiResponse.Loading -> {
                    _state.value = GenericsGetState(
                        isLoading = true
                    )
                }
                is ApiResponse.Success -> {
                    _state.value = GenericsGetState(
                        data = result.data?.toCharacter()
                    )
                }
                is ApiResponse.Failure -> {
                        _state.value = GenericsGetState(
                            error = result.msg
                        )
                }

            }
        }.launchIn(viewModelScope)

    }
}