package com.example.tiempo.data.response

import com.example.tiempo.data.db.entity.CurrentWeatherEntry
import com.example.tiempo.data.db.entity.Location
import com.example.tiempo.data.db.entity.Request
import com.google.gson.annotations.SerializedName


data class CurrentWeatherResponse(
    @SerializedName("current")
    val current: CurrentWeatherEntry,
    @SerializedName("location")
    val location: Location,
    @SerializedName("request")
    val request: Request
)