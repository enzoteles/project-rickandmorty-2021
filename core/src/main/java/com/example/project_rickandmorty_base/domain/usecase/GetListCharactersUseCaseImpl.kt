package com.example.project_rickandmorty_base.domain.usecase

import com.example.project_rickandmorty_base.commons.components.result
import com.example.project_rickandmorty_base.domain.repository.CharacterRepository
import javax.inject.Inject


class GetListCharactersUseCaseImpl @Inject constructor(
    private val repository: CharacterRepository
): GetListCharactersUseCase{

    override fun invoke() = result {
        repository.getListCharacters()
    }
}




