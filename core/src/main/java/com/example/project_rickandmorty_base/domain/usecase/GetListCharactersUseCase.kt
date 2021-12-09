package com.example.project_rickandmorty_base.domain.usecase

import com.example.project_rickandmorty_base.commons.components.ApiResponse
import com.example.project_rickandmorty_base.data.remote.list_characters.ListCharacters
import kotlinx.coroutines.flow.Flow

interface GetListCharactersUseCase {

    operator fun invoke() : Flow<ApiResponse<ListCharacters?>>
}