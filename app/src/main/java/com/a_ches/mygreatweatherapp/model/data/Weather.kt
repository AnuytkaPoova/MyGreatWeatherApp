package com.a_ches.mygreatweatherapp.model.data

data class Weather(
        val city: City = getDefaultCity(),
        val temperature: Int = 0,
        val feelsLike: Int = 0,
)

fun getDefaultCity() = City("Москва", 55.5578, 37.61729)