package com.example.tiempo.data.repository

import androidx.lifecycle.LiveData
import com.example.tiempo.data.db.entity.CurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(): LiveData<CurrentWeatherEntry>
}