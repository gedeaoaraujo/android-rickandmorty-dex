package com.acmelabs.rickandmortydex.data.network.location_service

data class LocationResponse(
    val id: Int?,
    val name: String,
    val type: String?,
    val dimension: String?,
    val residents: List<String>?,
    val url: String,
    val created: String?
)