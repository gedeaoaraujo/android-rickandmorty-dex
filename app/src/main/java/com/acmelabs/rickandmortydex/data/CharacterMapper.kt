package com.acmelabs.rickandmortydex.data

import com.acmelabs.rickandmortydex.data.database.entity.CharacterEntity
import com.acmelabs.rickandmortydex.data.network.character_service.CharacterResponse
import com.acmelabs.rickandmortydex.domain.model.CharacterModel

fun CharacterResponse.toModel(): CharacterModel {
    return CharacterModel(
        id = id,
        name = name,
        status = status,
        species = species,
        origin = origin.name,
        imageUrl = image
    )
}

fun CharacterResponse.toEntity(): CharacterEntity {
    return CharacterEntity(
        apiId = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        originId = urlToId(origin.url),
        locationId = urlToId(location.url),
        image = image,
        url = url,
        created = created,
        episodesIds = urlsToId(episode)
    )
}