package com.acmelabs.rickandmortydex.injection

import com.acmelabs.rickandmortydex.data.database.AppRoomDatabase
import com.acmelabs.rickandmortydex.data.database.CharacterDao
import com.acmelabs.rickandmortydex.data.network.character_service.CharacterService
import com.acmelabs.rickandmortydex.data.network.rickAndMortyClient
import com.acmelabs.rickandmortydex.data.repository.CharacterRepositoryImpl
import com.acmelabs.rickandmortydex.domain.repository.CharacterRepository
import com.acmelabs.rickandmortydex.presentation.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val rickAndMortyModule = module {
    single<CharacterService> {
        rickAndMortyClient(CharacterService::class.java)
    }
    single<CharacterDao> {
        AppRoomDatabase.getDatabase(androidContext()).characterDao()
    }
    singleOf(::CharacterRepositoryImpl) { bind<CharacterRepository>() }
    singleOf(::HomeViewModel)
}