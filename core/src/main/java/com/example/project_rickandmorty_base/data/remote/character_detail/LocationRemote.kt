package com.example.project_rickandmorty_base.data.remote.character_detail

import com.example.project_rickandmorty_base.domain.model.character_detail.LocationMapper

data class LocationRemote(
    val name: String,
    val url: String
)

fun LocationRemote.toLocation() = LocationMapper(
    name = name,
    url = url
)