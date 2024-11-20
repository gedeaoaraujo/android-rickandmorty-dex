package com.acmelabs.rickandmortydex.data.repository

import com.acmelabs.rickandmortydex.data.network.character_service.CharacterResponse
import com.acmelabs.rickandmortydex.data.network.character_service.CharacterService

class CharacterRepository(
    private val characterService: CharacterService
) {

    suspend fun getAllCharacters(): List<CharacterResponse> {
        val response = characterService.getAllCharacters()
        return response.body()?.results.orEmpty()
    }

}