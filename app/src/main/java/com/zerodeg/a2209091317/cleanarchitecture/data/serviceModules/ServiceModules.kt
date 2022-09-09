package com.zerodeg.a2209091317.cleanarchitecture.data.serviceModules

import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import com.zerodeg.a2209091317.cleanarchitecture.data.repositories.PhotoRepo
import com.zerodeg.a2209091317.cleanarchitecture.data.services.APIHelper
import com.zerodeg.a2209091317.cleanarchitecture.data.services.APIHelperImpl
import com.zerodeg.a2209091317.cleanarchitecture.data.services.PhotoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModules {

    @Provides
    @Singleton
    fun provideBaseUrl() = "https://api.unsplash.com/"

    @Provides
    @Singleton
    fun provideRetrofit(
        baseUrl: String,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val httpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)
            .addNetworkInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .addInterceptor(HttpLoggingInterceptor())
            .addNetworkInterceptor { chain ->
                val request = chain.request()
                val builder: Request.Builder = request.newBuilder()
                builder.addHeader("Authorization", "Client-ID 6U-FmpLuxzAv1dIJk_nzaYYRHZJab7iQA-wB9uXhIio")
                chain.proceed(builder.build())
            }

        return httpClientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideShowInfoService(retrofit: Retrofit): PhotoService = retrofit.create(PhotoService::class.java)

    @Provides
    @Singleton
    fun provideShowInfoHelperImpl(showInfoService: PhotoService) = APIHelperImpl(showInfoService)

    @Provides
    @Singleton
    fun provideShowInfoHelper(showInfoHelper: APIHelperImpl): APIHelper = showInfoHelper

    @Provides
    @Singleton
    fun provideShowInfoRepo(showInfoHelper: APIHelper): PhotoRepo = PhotoRepo(showInfoHelper)

}