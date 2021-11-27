package com.example.project_rickandmorty_base.data.remote.list_characters

import com.example.project_rickandmorty_base.domain.model.list_characters.InfoMapper

data class InfoRemote(
    val count: Int,
    val next: String,
    val pages: Int,
)

fun InfoRemote.toInfo() = InfoMapper(
    count = count.toString(),
    next = next,
    pages = pages
)