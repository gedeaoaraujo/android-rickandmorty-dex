package com.acmelabs.rickandmortydex.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acmelabs.rickandmortydex.R
import com.acmelabs.rickandmortydex.domain.repository.CharacterRepository
import com.acmelabs.rickandmortydex.domain.repository.Status.ClientError
import com.acmelabs.rickandmortydex.domain.repository.Status.Ok
import com.acmelabs.rickandmortydex.domain.repository.Status.Redirect
import com.acmelabs.rickandmortydex.domain.repository.Status.ServerError
import com.acmelabs.rickandmortydex.domain.repository.Status.Unknown
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    private val _state = MutableStateFlow(HomeScreenState())
    val state: StateFlow<HomeScreenState> = _state.asStateFlow()

    init {
        getAll()
    }

    private fun getAll() = viewModelScope.launch {
        when (val response = characterRepository.getAllCharacters()){
            is Ok -> response.body?.let { characters ->
                _state.update { it.copy(characters = characters, resError = null) }
            }
            is Redirect, is ServerError, is ClientError -> {
                _state.update { it.copy(resError = R.string.error_dialog_text) }
            }
            is Unknown -> {
                _state.update { it.copy(resError =  R.string.error_dialog_unknown) }
            }
        }
    }

    fun onAction(action: HomeScreenActions){
        when(action){
            HomeScreenActions.OnDialogTryAgain -> getAll()
        }
    }

}