package com.acmelabs.rickandmortydex.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey
    val apiId: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val originId: Int,
    val locationId: Int,
    val image: String,
    val url: String,
    val created: String
)