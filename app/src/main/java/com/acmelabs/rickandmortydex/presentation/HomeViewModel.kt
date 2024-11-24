package com.acmelabs.rickandmortydex.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acmelabs.rickandmortydex.data.repository.CharacterRepository
import com.acmelabs.rickandmortydex.domain.model.CharacterModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    private val _characters = MutableStateFlow<List<CharacterModel>>(emptyList())
    val characters: StateFlow<List<CharacterModel>> = _characters

    init {
        getAll()
    }

    private fun getAll() = viewModelScope.launch {
        val response = characterRepository.getAllCharacters()
        _characters.value = response
    }

}