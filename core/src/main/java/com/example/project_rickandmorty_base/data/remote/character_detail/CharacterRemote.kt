package com.example.project_rickandmorty_base.data.remote.character_detail

import com.example.project_rickandmorty_base.domain.model.character_detail.CharacterMapper

data class CharacterRemote(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val locationRemote: LocationRemote,
    val name: String,
    val originRemote: OriginRemote,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun CharacterRemote.toCharacter() = CharacterMapper(
    created = created,
    episode = episode,
    gender = gender,
    id = id,
    image = image,
    locationRemote = locationRemote.toLocation(),
    name = name,
    originRemote = originRemote.toOrigin(),
    species = species,
    status = status,
    type = type,
    url = url
)