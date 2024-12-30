package com.acmelabs.rickandmortydex.domain.repository

import com.acmelabs.rickandmortydex.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun loadTheWorld()
    fun getAllCharacters(): Flow<List<CharacterModel>>
    fun getCharacterById(id: Int): Flow<CharacterModel>
}