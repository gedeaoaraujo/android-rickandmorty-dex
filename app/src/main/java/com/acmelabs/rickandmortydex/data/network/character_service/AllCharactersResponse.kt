package com.acmelabs.rickandmortydex.data.network.character_service

data class AllCharactersResponse(
    val info: InfoResponse,
    val results: List<CharacterResponse>
)