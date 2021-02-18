package com.example.tiempo.data.response

import com.example.tiempo.data.response.Current
import com.example.tiempo.data.response.Location
import com.example.tiempo.data.response.Request
import com.google.gson.annotations.SerializedName


data class TiempoHoy(
    @SerializedName("current")
    val current: Current,
    @SerializedName("location")
    val location: Location,
    @SerializedName("request")
    val request: Request
)