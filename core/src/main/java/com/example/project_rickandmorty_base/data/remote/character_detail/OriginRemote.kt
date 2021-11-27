package com.example.project_rickandmorty_base.data.remote.character_detail

import com.example.project_rickandmorty_base.domain.model.character_detail.OriginMapper

data class OriginRemote(
    val name: String,
    val url: String
)

fun OriginRemote.toOrigin() = OriginMapper(
    name = name,
    url = url
)