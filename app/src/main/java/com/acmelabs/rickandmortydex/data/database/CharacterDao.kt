package com.acmelabs.rickandmortydex.data.database

import androidx.room.Dao
import androidx.room.Upsert
import com.acmelabs.rickandmortydex.data.database.entity.CharacterEntity

@Dao
interface CharacterDao {

    @Upsert
    suspend fun upsert(characters: List<CharacterEntity>)
}