package com.acmelabs.rickandmortydex.data

import com.acmelabs.rickandmortydex.data.database.entity.LocationEntity
import com.acmelabs.rickandmortydex.data.network.location_service.LocationResponse

fun LocationResponse.toEntity(): LocationEntity {
    return LocationEntity(name = name, url = url)
}