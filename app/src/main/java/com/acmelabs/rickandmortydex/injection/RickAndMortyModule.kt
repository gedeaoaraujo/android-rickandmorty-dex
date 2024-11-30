package com.acmelabs.rickandmortydex.injection

import com.acmelabs.rickandmortydex.data.database.AppRoomDatabase
import com.acmelabs.rickandmortydex.data.database.CharacterDao
import com.acmelabs.rickandmortydex.data.database.EpisodeDao
import com.acmelabs.rickandmortydex.data.database.LocationDao
import com.acmelabs.rickandmortydex.data.network.character_service.CharacterService
import com.acmelabs.rickandmortydex.data.network.episode_service.EpisodeService
import com.acmelabs.rickandmortydex.data.network.location_service.LocationService
import com.acmelabs.rickandmortydex.data.network.rickAndMortyClient
import com.acmelabs.rickandmortydex.data.repository.CharacterRepositoryImpl
import com.acmelabs.rickandmortydex.domain.repository.CharacterRepository
import com.acmelabs.rickandmortydex.presentation.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val rickAndMortyModule = module {
    single<CharacterService> { rickAndMortyClient(CharacterService::class.java) }
    single<EpisodeService> { rickAndMortyClient(EpisodeService::class.java) }
    single<LocationService> { rickAndMortyClient(LocationService::class.java) }
    single<CharacterDao> { AppRoomDatabase.getDatabase(androidContext()).characterDao() }
    single<EpisodeDao> { AppRoomDatabase.getDatabase(androidContext()).episodeDao() }
    single<LocationDao> { AppRoomDatabase.getDatabase(androidContext()).locationDao() }
    singleOf(::CharacterRepositoryImpl) { bind<CharacterRepository>() }
    singleOf(::HomeViewModel)
}