package com.a_ches.mygreatweatherapp.model.repository

import com.a_ches.mygreatweatherapp.model.data.Weather
import com.a_ches.mygreatweatherapp.model.data.convertHistoryEntityToWeather
import com.a_ches.mygreatweatherapp.model.data.convertWeatherToEntity
import com.a_ches.mygreatweatherapp.room.HistoryDao


class LocalRepositoryImpl(private val localDataSource: HistoryDao) : LocalRepository {
    override fun getAllHistory(): List<Weather> {
        return convertHistoryEntityToWeather(localDataSource.all())
    }

    override fun saveEntity(weather: Weather) {
        return localDataSource.insert(convertWeatherToEntity(weather))
    }
}