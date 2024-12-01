package com.acmelabs.rickandmortydex.data.network.episode_service

import com.acmelabs.rickandmortydex.data.network.character_service.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodeService {

    @GET("episode")
    suspend fun getAllEpisodes(
        @Query("page") page: Int = 1
    ): Response<ApiResponse<EpisodeResponse>>
}