package com.acmelabs.rickandmortydex.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acmelabs.rickandmortydex.domain.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    private val _characters = characterRepository.getAllCharacters()

    private val _state = MutableStateFlow(HomeScreenState())
    val state: StateFlow<HomeScreenState> = _state
        .onStart {
            loadAllRemoteData()
            _characters.onEach { chars ->
                _state.update { it.copy(characters = chars) }
            }.stateIn(viewModelScope)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = _state.value
        )

    private fun loadAllRemoteData() = viewModelScope.launch(Dispatchers.IO) {
        _state.update { it.copy(isLoading = true) }
        characterRepository.loadTheWorld()
        _state.update { it.copy(isLoading = false) }
    }

    fun onAction(action: HomeScreenActions){
        when(action){
            HomeScreenActions.OnDialogTryAgain -> loadAllRemoteData()
        }
    }

}