package com.zerodeg.a2209091317.cleanarchitecture.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnFailure
import com.skydoves.sandwich.suspendOnSuccess
import com.zerodeg.a2209091317.cleanarchitecture.data.repositories.PhotoRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val showInfoRepo: PhotoRepo,
) : ViewModel() {

    private val accessKey = "6U-FmpLuxzAv1dIJk_nzaYYRHZJab7iQA-wB9uXhIio"
    private val secretKey = "Bqw1hJXhRB-faoONIOd3HCTJjvvwT3fQHdfnWIM34VQ"

    suspend fun getShowInfo(
        key: String,
    ) {
        Log.d("MainViewModel", "Hello Hilt App! In Model")
        showInfoRepo.getPhotos(key)
            .suspendOnSuccess {
                Log.d("MainViewModel", "success")
            }.suspendOnError {
                Log.d("MainViewModel", "on Error")
            }.suspendOnException {
                Log.d("MainViewModel", "on Exception ${this.message}")
            }.suspendOnFailure {
                Log.d("MainViewModel", "on Failure")
            }

    }


}