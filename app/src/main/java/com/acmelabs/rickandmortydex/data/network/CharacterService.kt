package com.acmelabs.rickandmortydex.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {

    @GET("character/{charId}")
    suspend fun getCharacterById(
        @Path("charId") charId: Int
    ): Response<CharacterResponse>
}