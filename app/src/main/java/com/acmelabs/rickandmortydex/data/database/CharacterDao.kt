package com.acmelabs.rickandmortydex.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.acmelabs.rickandmortydex.data.database.entity.CharacterEntity
import com.acmelabs.rickandmortydex.data.database.relation.CharacterLocationRelation
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Upsert
    suspend fun upsert(characters: List<CharacterEntity>)

    @Transaction
    @Query("SELECT * FROM characters")
    fun getAllCharacters(): Flow<List<CharacterLocationRelation>>
}