package com.a_ches.mygreatweatherapp.model.repository

import com.a_ches.mygreatweatherapp.model.data.Weather


interface Repository {
    fun getWeatherFromServer(): Weather
    fun getWeatherFromLocalStorageRus(): List<Weather>
    fun getWeatherFromLocalStorageWorld(): List<Weather>
}
