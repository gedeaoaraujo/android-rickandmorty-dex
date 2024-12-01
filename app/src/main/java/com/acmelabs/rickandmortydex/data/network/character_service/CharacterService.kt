package com.acmelabs.rickandmortydex.data.network.character_service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {

    @GET("character/{charId}")
    suspend fun getCharacterById(
        @Path("charId") charId: Int
    ): Response<CharacterResponse>

    @GET("character")
    suspend fun getAllCharacters(
        @Query("page") page: Int = 1
    ): Response<ApiResponse<CharacterResponse>>
}