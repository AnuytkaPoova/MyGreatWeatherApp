package com.a_ches.mygreatweatherapp.model.repository

import com.a_ches.mygreatweatherapp.model.data.Weather
import com.a_ches.mygreatweatherapp.model.data.getRussianCities
import com.a_ches.mygreatweatherapp.model.data.getWorldCities

class RepositoryImpl : Repository {
    override fun getWeatherFromServer() = Weather()
    override fun getWeatherFromLocalStorageRus() = getRussianCities()
    override fun getWeatherFromLocalStorageWorld() = getWorldCities()
}