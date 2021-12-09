package com.example.project_rickandmorty_base.domain.usecase

import com.example.project_rickandmorty_base.commons.components.ApiResponse
import com.example.project_rickandmorty_base.data.remote.list_characters.ListCharacters
import kotlinx.coroutines.flow.Flow

interface GetCharacterFilterUseCase {

    operator fun invoke(name: String?,
                        status: String?,
                        species: String?,
                        type: String?,
                        gender: String?,) : Flow<ApiResponse<ListCharacters?>>
    }
