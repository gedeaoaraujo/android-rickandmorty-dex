package com.acmelabs.rickandmortydex.data.network.location_service

import com.acmelabs.rickandmortydex.data.network.character_service.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationService {

    @GET("location")
    suspend fun getAllLocations(
        @Query("page") page: Int = 1
    ): Response<ApiResponse<LocationResponse>>
}