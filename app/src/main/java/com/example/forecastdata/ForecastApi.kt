package com.example.forecastdata

import android.annotation.SuppressLint
import android.util.Log
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastApi {
    @GET("reverse?format=json&accept-language=ru&zoom=18")
    suspend fun getForecastJson(
        @Query("lon") lon: String,
        @Query("lat") lat: String
    ): ForecastResponse


    companion object {
        const val BASE_URL = "https://nominatim.openstreetmap.org/"

        @SuppressLint("SuspiciousIndentation")
        fun create(): ForecastApi {
            val contentType = "application/json".toMediaType()
            val converterFactory = Json { ignoreUnknownKeys = true }.asConverterFactory(contentType)
            val loggingInterceptor = HttpLoggingInterceptor { message -> Log.d("OkHttp", message) }
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            val okhttp = OkHttpClient.Builder()
                .addNetworkInterceptor(loggingInterceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okhttp)
                .addConverterFactory(converterFactory)
                .build()
            return retrofit.create(ForecastApi::class.java)
        }

    }


}