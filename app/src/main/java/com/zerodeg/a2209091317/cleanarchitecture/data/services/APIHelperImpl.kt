package com.zerodeg.a2209091317.cleanarchitecture.data.services

import com.skydoves.sandwich.ApiResponse
import com.zerodeg.a2209091317.cleanarchitecture.data.entities.Photos
import javax.inject.Inject

class APIHelperImpl @Inject constructor(private val photoService: PhotoService): APIHelper {

    override suspend fun getPhotos(key: String): ApiResponse<Photos> = photoService.getShowInfo(key)


}