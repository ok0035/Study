package com.zerodeg.a2209091317.cleanarchitecture.data.services

import com.skydoves.sandwich.ApiResponse
import com.zerodeg.a2209091317.cleanarchitecture.data.entities.Photos
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoService {

    @GET("/search/photos")
    suspend fun getShowInfo(
        @Query("query") key: String
    ): ApiResponse<Photos>

}