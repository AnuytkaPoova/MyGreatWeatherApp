package com.a_ches.mygreatweatherapp.model.repository

import com.a_ches.mygreatweatherapp.model.data.Weather


interface LocalRepository {
    fun getAllHistory(): List<Weather>
    fun saveEntity(weather: Weather)
}