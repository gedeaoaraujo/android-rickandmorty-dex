package com.acmelabs.rickandmortydex.data.database

import androidx.room.Dao
import androidx.room.Upsert
import com.acmelabs.rickandmortydex.data.database.entity.LocationEntity

@Dao
interface LocationDao {

    @Upsert
    suspend fun upsert(characters: List<LocationEntity>)
}