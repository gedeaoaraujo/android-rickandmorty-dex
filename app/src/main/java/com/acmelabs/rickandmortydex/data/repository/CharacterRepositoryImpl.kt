package com.acmelabs.rickandmortydex.data.repository

import com.acmelabs.rickandmortydex.data.network.character_service.CharacterService
import com.acmelabs.rickandmortydex.data.toModel
import com.acmelabs.rickandmortydex.domain.model.CharacterModel
import com.acmelabs.rickandmortydex.domain.repository.CharacterRepository

class CharacterRepositoryImpl(
    private val characterService: CharacterService
): CharacterRepository {

    override suspend fun getAllCharacters(): List<CharacterModel> {
        val response = characterService.getAllCharacters()
        val models = response.body()?.results?.map { it.toModel() }
        return models.orEmpty()
    }

}