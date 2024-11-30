package com.acmelabs.rickandmortydex.data

import com.acmelabs.rickandmortydex.data.database.entity.EpisodeEntity
import com.acmelabs.rickandmortydex.data.network.episode_service.EpisodeResponse

fun EpisodeResponse.toEntity(): EpisodeEntity {
    return EpisodeEntity(
        id = id,
        url = url,
        name = name,
        episode = episode,
        created = created,
        airDate = air_date,
        charactersIds = urlsToId(characters)
    )
}