package com.acmelabs.rickandmortydex.data

import com.acmelabs.rickandmortydex.data.network.character_service.CharacterResponse
import com.acmelabs.rickandmortydex.domain.model.CharacterModel

fun CharacterResponse.toModel(): CharacterModel {
    return CharacterModel(
        id = id,
        name = name,
        status = status,
        species = species,
        origin = origin.name
    )
}