package com.acmelabs.rickandmortydex.data

import com.acmelabs.rickandmortydex.data.database.entity.OriginEntity
import com.acmelabs.rickandmortydex.data.network.character_service.OriginResponse

fun OriginResponse.toEntity(): OriginEntity {
    return OriginEntity(name = name, url = url)
}