package com.acmelabs.rickandmortydex.data

import com.acmelabs.rickandmortydex.data.database.entity.LocationEntity
import com.acmelabs.rickandmortydex.data.network.location_service.LocationResponse

fun LocationResponse.toEntity(): LocationEntity {
    return LocationEntity(
        id = id,
        name = name,
        type = type,
        dimension = dimension,
        charactersIds = urlsToId(residents),
        url = url,
        created = created
    )
}