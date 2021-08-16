package com.a_ches.mygreatweatherapp.model.data

import com.a_ches.mygreatweatherapp.model.dto.WeatherDTO

fun convertDtoToModel(weatherDTO: WeatherDTO): List<Weather> {
    val fact = weatherDTO.fact!!
    return listOf(
            Weather(
                    getDefaultCity(),
                    fact.temp!!,
                    fact.feels_like!!,
                    fact.condition!!
            )
    )
}