package com.acmelabs.rickandmortydex.domain.repository

import com.acmelabs.rickandmortydex.domain.model.CharacterModel

interface CharacterRepository {
    suspend fun loadTheWorld()
    suspend fun getAllCharacters(): Status<List<CharacterModel>>
}