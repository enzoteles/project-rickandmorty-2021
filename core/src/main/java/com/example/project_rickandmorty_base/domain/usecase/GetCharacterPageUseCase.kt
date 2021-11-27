package com.example.project_rickandmorty_base.domain.usecase

import com.example.project_rickandmorty_base.commons.components.result
import com.example.project_rickandmorty_base.domain.repository.CharacterRepository

class GetCharacterPageUseCase(
    private val repository: CharacterRepository
){
    operator fun invoke(pageIndex: Int) = result {
        repository.getCharactersPage(pageIndex)
    }
}




