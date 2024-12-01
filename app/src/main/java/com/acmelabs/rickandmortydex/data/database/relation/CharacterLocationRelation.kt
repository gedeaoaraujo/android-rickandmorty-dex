package com.acmelabs.rickandmortydex.data.database.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.acmelabs.rickandmortydex.data.database.entity.CharacterEntity
import com.acmelabs.rickandmortydex.data.database.entity.LocationEntity

data class CharacterLocationRelation(
    @Embedded
    val character: CharacterEntity,
    @Relation(
        parentColumn = "originId",
        entityColumn = "id"
    )
    val location: LocationEntity?
)
