package com.acmelabs.rickandmortydex.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "episodes")
data class EpisodeEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    @ColumnInfo("air_date")
    val airDate: String,
    val episode: String,
    val url: String,
    val created: String,
    val charactersIds: String
)