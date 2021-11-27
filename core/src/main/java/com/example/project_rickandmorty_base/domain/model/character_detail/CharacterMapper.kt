package com.example.project_rickandmorty_base.domain.model.character_detail

data class CharacterMapper(
    val created: String = "",
    val episode: List<String> = listOf(),
    val gender: String = "",
    val id: Int,
    val image: String = "",
    val locationRemote: LocationMapper = LocationMapper(),
    val name: String = "",
    val originRemote: OriginMapper = OriginMapper(),
    val species: String = "",
    val status: String = "",
    val type: String = "",
    val url: String = ""
)