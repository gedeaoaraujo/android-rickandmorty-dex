package com.acmelabs.rickandmortydex.data.network.character_service

import com.acmelabs.rickandmortydex.data.network.location_service.LocationResponse


data class CharacterResponse(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: LocationResponse,
    val location: LocationResponse,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)