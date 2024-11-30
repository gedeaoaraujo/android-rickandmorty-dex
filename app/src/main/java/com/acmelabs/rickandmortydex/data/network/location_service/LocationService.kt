package com.acmelabs.rickandmortydex.data.network.location_service

import com.acmelabs.rickandmortydex.data.network.character_service.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface LocationService {

    @GET("location")
    suspend fun getAllEpisodes(): Response<ApiResponse<LocationResponse>>
}