package com.example.tiempo.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tiempo.data.response.CurrentWeatherResponse
import java.io.IOException

class WeatherNetworkDataSourceImpl(
    private val WeatherApiService: WeatherService
) : WeatherNetworkDataSource {

    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String) {
        try {
            val fetchedCurrentWeather = WeatherApiService
                    .getCurrentWeather(location)
                    .await()
            _downloadedCurrentWeather.postValue(fetchedCurrentWeather)
        }
        catch (e: IOException) {
            Log.e("Connectivity", "No internet connection.", e)
        }
    }
}