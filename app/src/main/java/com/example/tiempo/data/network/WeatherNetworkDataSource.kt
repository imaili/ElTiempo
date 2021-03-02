package com.example.tiempo.data.network

import androidx.lifecycle.LiveData
import com.example.tiempo.data.db.entity.CurrentWeatherEntry
import com.example.tiempo.data.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String
    )
}