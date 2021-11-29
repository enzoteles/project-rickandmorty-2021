package com.example.project_rickandmorty_base.data.remote.list_characters

import com.example.project_rickandmorty_base.domain.model.list_characters.InfoMapper

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
)

fun Info.toInfo() = InfoMapper(
    count = count.toString(),
    next = next,
    pages = pages
)