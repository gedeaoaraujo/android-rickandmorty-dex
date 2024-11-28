package com.acmelabs.rickandmortydex.presentation

import com.acmelabs.rickandmortydex.domain.model.CharacterModel

data class HomeScreenState(
    val resError: Int? = null,
    val characters: List<CharacterModel> = emptyList()
)
