package com.example.tiempo.data.repository

import android.location.Location
import androidx.lifecycle.LiveData
import com.example.tiempo.data.db.entity.CurrentWeather
import com.example.tiempo.data.db.entity.CurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(): LiveData<CurrentWeather>
    suspend fun getWeatherLocation(): LiveData<Location>
}