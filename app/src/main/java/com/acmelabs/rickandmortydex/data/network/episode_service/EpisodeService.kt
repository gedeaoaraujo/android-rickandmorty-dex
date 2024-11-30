package com.acmelabs.rickandmortydex.data.network.episode_service

import com.acmelabs.rickandmortydex.data.network.character_service.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface EpisodeService {

    @GET("episode")
    suspend fun getAllEpisodes(): Response<ApiResponse<EpisodeResponse>>
}