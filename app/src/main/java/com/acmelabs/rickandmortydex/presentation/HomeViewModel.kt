package com.acmelabs.rickandmortydex.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acmelabs.rickandmortydex.R
import com.acmelabs.rickandmortydex.domain.model.CharacterModel
import com.acmelabs.rickandmortydex.domain.repository.CharacterRepository
import com.acmelabs.rickandmortydex.domain.repository.Status.ClientError
import com.acmelabs.rickandmortydex.domain.repository.Status.Ok
import com.acmelabs.rickandmortydex.domain.repository.Status.Redirect
import com.acmelabs.rickandmortydex.domain.repository.Status.ServerError
import com.acmelabs.rickandmortydex.domain.repository.Status.Unknown
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    private val _characters = MutableStateFlow<List<CharacterModel>>(emptyList())
    val characters: StateFlow<List<CharacterModel>> = _characters

    private val _error = MutableStateFlow<Int?>(null)
    val error: StateFlow<Int?> = _error

    init {
        getAll()
    }

    private fun getAll() = viewModelScope.launch {
        when (val response = characterRepository.getAllCharacters()){
            is Ok -> response.body?.let { _characters.value = it }
            is Redirect, is ServerError, is ClientError -> {
                _error.value = R.string.error_dialog_text
            }
            is Unknown -> _error.value = R.string.error_dialog_unknown
        }
    }

}