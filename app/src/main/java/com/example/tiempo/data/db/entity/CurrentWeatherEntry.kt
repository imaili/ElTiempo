package com.example.tiempo.data.db.entity

import androidx.room.*
import com.google.gson.annotations.SerializedName


data class CurrentWeatherEntry(

    @SerializedName("cloudcover")
    val cloudcover: Int,
    @SerializedName("feelslike")
    val feelslike: Int,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("is_day")
    val isDay: String,
    @SerializedName("observation_time")
    val observationTime: String,
    @SerializedName("precip")
    val precip: Int,
    @SerializedName("temperature")
    val temperature: Int,
    @SerializedName("wind_degree")
    val windDegree: Int,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("wind_speed")
    val windSpeed: Int,
    @SerializedName("weather_icons")
    val weatherIcons: List<String>,
    @SerializedName("weather_descriptions")
    var weatherDescriptions: List<String>,
    @SerializedName("visibility")
    var visibility: Int
)
