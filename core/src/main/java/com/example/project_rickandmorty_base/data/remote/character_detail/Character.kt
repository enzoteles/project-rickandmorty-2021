package com.example.project_rickandmorty_base.data.remote.character_detail

import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper

data class Character(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun Character.toCharacter() = CharacterMapper(
    created = created,
    episode = episode,
    gender = gender,
    id = id,
    image = image,
    locationRemote = location.toLocation(),
    name = name,
    originRemote = origin.toOrigin(),
    species = species,
    status = status,
    type = type,
    url = url
)