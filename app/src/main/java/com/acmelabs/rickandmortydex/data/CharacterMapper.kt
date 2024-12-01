package com.acmelabs.rickandmortydex.data

import com.acmelabs.rickandmortydex.data.database.relation.CharacterLocationRelation
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
        id = id,
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

fun CharacterLocationRelation.toModel(): CharacterModel {
    return CharacterModel(
        id = character.id,
        name = character.name,
        status = character.status,
        species = character.species,
        origin = location?.name.orEmpty(),
        imageUrl = character.image,
    )
}