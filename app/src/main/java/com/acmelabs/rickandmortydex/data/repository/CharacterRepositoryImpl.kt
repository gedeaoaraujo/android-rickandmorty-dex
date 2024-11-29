package com.acmelabs.rickandmortydex.data.repository

import com.acmelabs.rickandmortydex.data.database.CharacterDao
import com.acmelabs.rickandmortydex.data.network.character_service.CharacterService
import com.acmelabs.rickandmortydex.data.toEntity
import com.acmelabs.rickandmortydex.data.toModel
import com.acmelabs.rickandmortydex.domain.model.CharacterModel
import com.acmelabs.rickandmortydex.domain.repository.CharacterRepository
import com.acmelabs.rickandmortydex.domain.repository.Status
import com.acmelabs.rickandmortydex.domain.repository.safeCall
import com.acmelabs.rickandmortydex.domain.repository.wrapHttpStatus

class CharacterRepositoryImpl(
    private val characterDao: CharacterDao,
    private val characterService: CharacterService
): CharacterRepository {

    override suspend fun getAllCharacters(): Status<List<CharacterModel>> {
        val result = safeCall { characterService.getAllCharacters() }
        val list = result.body?.results.orEmpty()
        val entities = list.map { it.toEntity() }
        characterDao.upsert(entities)
        val models = list.map { it.toModel() }
        return wrapHttpStatus(models, result.code)
    }

}