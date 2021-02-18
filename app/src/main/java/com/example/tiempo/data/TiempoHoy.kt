package com.example.tiempo.data

import com.google.gson.annotations.SerializedName


data class TiempoHoy(
    @SerializedName("current")
    val current: Current,
    @SerializedName("location")
    val location: Location,
    @SerializedName("request")
    val request: Request
)