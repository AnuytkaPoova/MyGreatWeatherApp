package com.a_ches.mygreatweatherapp.model.repository


import retrofit2.http.*
import com.a_ches.mygreatweatherapp.model.dto.WeatherDTO
import retrofit2.Call


private const val REQUEST_API_KEY = "X-Yandex-API-Key"

interface WeatherAPI {
    @GET("v2/informers")
    fun getWeather(
            @Header(REQUEST_API_KEY) token: String,
            @Query("lat") lat: Double,
            @Query("lon") lon: Double
    ): Call<WeatherDTO>
}
