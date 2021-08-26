package com.a_ches.mygreatweatherapp.model

import com.a_ches.mygreatweatherapp.model.data.Weather


sealed class AppState {
    data class Success(val weatherData: List<Weather>) : AppState()
    class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}