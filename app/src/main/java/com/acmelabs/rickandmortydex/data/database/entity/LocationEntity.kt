package com.acmelabs.rickandmortydex.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class LocationEntity(
    @PrimaryKey
    val id: Int?,
    val name: String,
    val type: String?,
    val dimension: String?,
    val charactersIds: String?,
    val url: String,
    val created: String?
)