package com.acmelabs.rickandmortydex.domain.model

data class CharacterModel(
    val id: Int,
    val name: String,
    val status: String?,
    val species: String,
    val origin: String?,
    val imageUrl: String
)
