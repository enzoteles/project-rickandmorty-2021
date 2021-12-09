package com.example.project_rickandmorty_base.domain.usecase

import com.example.project_rickandmorty_base.commons.components.ApiResponse
import com.example.project_rickandmorty_base.data.remote.character_detail.Character
import com.example.project_rickandmorty_base.data.remote.list_characters.ListCharacters
import kotlinx.coroutines.flow.Flow

interface GetCharacterDetailUseCase {

    operator fun invoke(characterId: Int) : Flow<ApiResponse<Character?>>

}