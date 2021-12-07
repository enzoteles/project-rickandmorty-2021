package com.example.project_rickandmorty_base.presentation.ui.viewmodel.filter_character

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.project_rickandmorty_base.commons.components.ApiResponse
import com.example.project_rickandmorty_base.commons.utils.Constants
import com.example.project_rickandmorty_base.data.datasource.RickAndMortkDataSource
import com.example.project_rickandmorty_base.data.remote.character_detail.toCharacter
import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper
import com.example.project_rickandmorty_base.domain.usecase.GetCharacterFilterUseCase
import com.example.project_rickandmorty_base.presentation.ui.components.GenericsGetState
import com.example.project_rickandmorty_base.presentation.ui.paging.CharacterSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GetFilterCharactersViewModel @Inject constructor(
    private val getCharacterFilterUseCase: GetCharacterFilterUseCase,
    private val api: RickAndMortkDataSource,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private var _state = mutableStateOf(GenericsGetState<List<CharacterMapper>>())
    val state: State<GenericsGetState<List<CharacterMapper>>> = _state

    val _name: MutableLiveData<String> = savedStateHandle.getLiveData(Constants.PARAM_CHARACTER_FILTER_NAME, "")
    var name: LiveData<String> = _name

    val _status: MutableLiveData<String> = savedStateHandle.getLiveData(Constants.PARAM_CHARACTER_FILTER_STATUS, "")
    var status: LiveData<String> = _status

    private val _species: MutableLiveData<String> = savedStateHandle.getLiveData(Constants.PARAM_CHARACTER_FILTER_SPECIES, "")
    var species: LiveData<String> = _species

    private val _type: MutableLiveData<String> = savedStateHandle.getLiveData(Constants.PARAM_CHARACTER_FILTER_TYPE, "")
    var type: LiveData<String> = _type

    private val _gender: MutableLiveData<String> =  savedStateHandle.getLiveData(Constants.PARAM_CHARACTER_FILTER_GENDER, "")
    var gender: LiveData<String> = _gender

    val character: Flow<PagingData<CharacterMapper>> = Pager(PagingConfig(pageSize = 10)) {
        CharacterSource(api)
    }.flow.cachedIn(viewModelScope)

    fun getListCharactersFilter() {
        getCharacterFilterUseCase.invoke(
            name = name.value,
            status = status.value,
            species = species.value,
            type = type.value,
            gender = gender.value
        ).onEach { result ->
            delay(1000)
            when (result) {
                is ApiResponse.Loading -> {
                    _state.value = GenericsGetState(
                        isLoading = true
                    )
                }
                is ApiResponse.Success -> {
                    _state.value = GenericsGetState(
                        isLoading = false,
                        data = result.data?.results?.map { it.toCharacter() }
                    )
                }
                is ApiResponse.Failure -> {
                        _state.value = GenericsGetState(
                            isLoading = false,
                            error = result.msg
                        )
                }

            }
        }.launchIn(viewModelScope)

    }

    fun onNameChange(newName: String){
        _name.value = newName
    }
    fun onStatusChange(newStatus: String){
        _status.value = newStatus
    }
    fun onSpeciesChange(newSpecies: String){
        _species.value = newSpecies
    }
    fun onTypeChange(newTyoe: String){
        _type.value = newTyoe
    }
    fun onGenderChange(newGender: String){
        _gender.value = newGender
    }
}