package com.example.tiempo.data.provider

import com.example.tiempo.data.db.entity.Location


interface LocationProvider {
    suspend fun hasLocationChanged(lastWeatherLocation: Location): Boolean
    suspend fun getPreferredLocationString(): String
}