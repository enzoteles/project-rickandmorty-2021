package com.example.project_rickandmorty_base.domain.usecase

import com.example.project_rickandmorty_base.commons.components.result
import com.example.project_rickandmorty_base.domain.repository.CharacterRepository
import javax.inject.Inject


class GetListCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
){
    operator fun invoke() = result {
        repository.getListCharacters()
    }
}




