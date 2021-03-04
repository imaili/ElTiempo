package com.example.tiempo.ui.current

import androidx.lifecycle.ViewModel
import com.example.tiempo.data.repository.ForecastRepository
import com.example.tiempo.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {


    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather()
    }

    val location by lazyDeferred {
        forecastRepository.getWeatherLocation()
    }
}