package com.zerodeg.a2209091317.cleanarchitecture.data.entities


import com.google.gson.annotations.SerializedName

data class Photos(
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)