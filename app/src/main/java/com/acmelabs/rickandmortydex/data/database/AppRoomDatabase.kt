package com.acmelabs.rickandmortydex.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.acmelabs.rickandmortydex.data.database.dao.CharacterDao
import com.acmelabs.rickandmortydex.data.database.dao.EpisodeDao
import com.acmelabs.rickandmortydex.data.database.dao.LocationDao
import com.acmelabs.rickandmortydex.data.database.entity.CharacterEntity
import com.acmelabs.rickandmortydex.data.database.entity.EpisodeEntity
import com.acmelabs.rickandmortydex.data.database.entity.LocationEntity

@Database(
    version = 1,
    exportSchema = false,
    entities = [
        CharacterEntity::class,
        LocationEntity::class,
        EpisodeEntity::class
    ]
)
abstract class AppRoomDatabase : RoomDatabase(){
    abstract fun characterDao(): CharacterDao
    abstract fun locationDao(): LocationDao
    abstract fun episodeDao(): EpisodeDao

    companion object {
        fun getDatabase(context: Context): AppRoomDatabase {
            return synchronized(this) {
                Room.databaseBuilder(
                    name = "app_db",
                    klass = AppRoomDatabase::class.java,
                    context = context.applicationContext
                ).build()
            }
        }
    }
}