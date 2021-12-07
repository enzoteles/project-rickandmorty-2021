package com.example.project_rickandmorty_base.domain.model.list_characters

import java.io.Serializable

data class InfoMapper(
    val count: String = "",
    val next: String = "",
    val pages: Int = 0,
): Serializable