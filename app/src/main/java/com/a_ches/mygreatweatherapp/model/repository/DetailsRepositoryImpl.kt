package com.a_ches.mygreatweatherapp.model.repository

import com.a_ches.mygreatweatherapp.model.dto.WeatherDTO

class DetailsRepositoryImpl(private val remoteDataSource: RemoteDataSource) : DetailsRepository {
    override fun getWeatherDetailsFromServer(
            lat: Double,
            lon: Double,
            callback: retrofit2.Callback<WeatherDTO>
    ) {
        remoteDataSource.getWeatherDetails(lat, lon, callback)
    }
}