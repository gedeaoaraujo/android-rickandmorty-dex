package com.acmelabs.rickandmortydex.presentation.details

import androidx.lifecycle.ViewModel
import com.acmelabs.rickandmortydex.data.database.relation.CharacterLocationRelation
import com.acmelabs.rickandmortydex.data.repository.CharacterRepositoryImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest

class DetailsViewModel(
    private val characterRepository: CharacterRepositoryImpl
): ViewModel() {

    private val _characterId = MutableStateFlow(0)

    @OptIn(ExperimentalCoroutinesApi::class)
    val charLoc: Flow<CharacterLocationRelation> = _characterId
        .flatMapLatest { id -> characterRepository.getCharacterById(id) }

    fun loadSelectedCharacter(characterId: Int) {
        _characterId.value = characterId
    }

}