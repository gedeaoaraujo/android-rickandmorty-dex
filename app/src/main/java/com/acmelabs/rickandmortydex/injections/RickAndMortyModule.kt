package com.acmelabs.rickandmortydex.injections

import com.acmelabs.rickandmortydex.data.network.character_service.CharacterService
import com.acmelabs.rickandmortydex.data.network.rickAndMortyClient
import com.acmelabs.rickandmortydex.data.repository.CharacterRepository
import com.acmelabs.rickandmortydex.presentation.HomeViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val rickAndMortyModule = module {
    single<CharacterService> {
        rickAndMortyClient(CharacterService::class.java)
    }
    singleOf(::CharacterRepository)
    singleOf(::HomeViewModel)
}