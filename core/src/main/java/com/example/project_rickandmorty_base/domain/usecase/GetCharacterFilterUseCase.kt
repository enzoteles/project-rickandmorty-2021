package com.example.project_rickandmorty_base.domain.usecase

import com.example.project_rickandmorty_base.commons.components.result
import com.example.project_rickandmorty_base.domain.repository.CharacterRepository
import javax.inject.Inject

class GetCharacterFilterUseCase @Inject constructor(
    private val repository: CharacterRepository
){
    operator fun invoke(name: String?,
                        status: String?,
                        species: String?,
                        type: String?,
                        gender: String?,) = result {
        repository.getCharacterFilter(name, status, species, type, gender)
    }
}




