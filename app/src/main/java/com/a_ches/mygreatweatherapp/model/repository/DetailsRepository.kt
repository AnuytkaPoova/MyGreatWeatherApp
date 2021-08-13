package com.a_ches.mygreatweatherapp.model.repository

import com.a_ches.mygreatweatherapp.model.dto.WeatherDTO

interface DetailsRepository {
    fun getWeatherDetailsFromServer(
            lat: Double,
            lon: Double,
            callback: retrofit2.Callback<WeatherDTO>
    )
}