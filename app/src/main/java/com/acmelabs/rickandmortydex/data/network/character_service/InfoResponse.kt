package com.acmelabs.rickandmortydex.data.network.character_service

data class InfoResponse(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String?
)