package com.acmelabs.rickandmortydex.data.database

import androidx.room.Dao
import androidx.room.Upsert
import com.acmelabs.rickandmortydex.data.database.entity.OriginEntity

@Dao
interface OriginDao {

    @Upsert
    suspend fun upsert(characters: List<OriginEntity>)
}