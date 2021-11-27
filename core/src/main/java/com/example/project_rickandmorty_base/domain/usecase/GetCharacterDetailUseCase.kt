package com.example.project_rickandmorty_base.domain.usecase

import com.example.project_rickandmorty_base.commons.components.result
import com.example.project_rickandmorty_base.domain.repository.CharacterRepository

class GetCharacterDetailUseCase(
    private val repository: CharacterRepository
){
    operator fun invoke(characterId: Int) = result {
        repository.getCharacterDetail(characterId)
    }
}




