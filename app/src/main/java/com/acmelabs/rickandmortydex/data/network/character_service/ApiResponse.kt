package com.acmelabs.rickandmortydex.data.network.character_service

data class ApiResponse<T>(
    val info: InfoResponse,
    val results: List<T>
)