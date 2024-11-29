package com.acmelabs.rickandmortydex.data.database

import androidx.room.Dao
import androidx.room.Upsert
import com.acmelabs.rickandmortydex.data.database.entity.EpisodeEntity

@Dao
interface EpisodeDao {

    @Upsert
    suspend fun upsert(characters: List<EpisodeEntity>)
}