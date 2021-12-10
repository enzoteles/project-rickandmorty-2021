package com.example.project_rickandmorty_base.domain.model.character_detail

import java.io.Serializable


data class CharacterMapper(
    val created: String = "",
    val episode: List<String> = listOf(),
    var gender: String = "",
    val id: Int = 0,
    val image: String = "",
    val locationRemote: LocationMapper = LocationMapper(),
    var name: String = "",
    val originRemote: OriginMapper = OriginMapper(),
    var species: String = "",
    var status: String = "",
    var type: String = "",
    val url: String = ""
)