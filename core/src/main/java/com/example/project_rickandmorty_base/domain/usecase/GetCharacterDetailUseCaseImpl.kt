package com.example.project_rickandmorty_base.domain.usecase

import com.example.project_rickandmorty_base.commons.components.result
import com.example.project_rickandmorty_base.domain.repository.CharacterRepository
import javax.inject.Inject

class GetCharacterDetailUseCaseImpl @Inject constructor(
    private val repository: CharacterRepository
): GetCharacterDetailUseCase{


    override fun invoke(characterId: Int) = result {
        repository.getCharacterDetail(characterId)
    }

}




