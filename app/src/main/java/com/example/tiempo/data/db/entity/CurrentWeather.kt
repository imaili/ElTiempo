package com.example.tiempo.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val CURRENT_WEATHER_ID = 0

@Entity(tableName = "current_weather")
data class CurrentWeather(

    var cloudcover: Int,

    var feelslike: Int,

    var humidity: Int,

    var day: String,

    var observationTime: String,

    var precip: Int,

    var temperature: Int,

    var windDegree: Int,

    var windDir: String,

    var windSpeed: Int,
/*
    var weatherIcon: String,

    var weatherDescription: String,*/

    var visibility: Int
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = CURRENT_WEATHER_ID

    companion object {
        public fun fromJson(entry: CurrentWeatherEntry) : CurrentWeather {
            return CurrentWeather(
                entry.cloudcover,
                entry.feelslike,
                entry.humidity,
                entry.isDay,
                entry.observationTime,
                entry.precip,
                entry.temperature,
                entry.windDegree,
                entry.windDir,
                entry.windSpeed,
                /*entry.weatherIcons[0],
                entry.weatherDescriptions[0],*/
                entry.visibility
            )

        }
    }
}