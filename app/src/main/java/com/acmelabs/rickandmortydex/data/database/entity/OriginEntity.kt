package com.acmelabs.rickandmortydex.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "origins")
data class OriginEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val url: String
)