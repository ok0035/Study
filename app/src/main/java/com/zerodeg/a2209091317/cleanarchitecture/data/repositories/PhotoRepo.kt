package com.zerodeg.a2209091317.cleanarchitecture.data.repositories

import com.skydoves.sandwich.ApiResponse
import com.zerodeg.a2209091317.cleanarchitecture.data.entities.Photos
import com.zerodeg.a2209091317.cleanarchitecture.data.services.APIHelper
import javax.inject.Inject

class PhotoRepo @Inject constructor(private val apiHelper: APIHelper) {

    suspend fun getPhotos(
        key: String
    ): ApiResponse<Photos> = apiHelper.getPhotos(key)

}