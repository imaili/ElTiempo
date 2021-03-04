package com.example.tiempo.data.provider

import android.content.Context
import com.example.tiempo.data.db.entity.Location

const val CUSTOM_LOCATION = "CUSTOM_LOCATION"

class LocationProviderImpl(
    context: Context
) : LocationProvider, PreferenceProvider(context){
    override suspend fun hasLocationChanged(lastWeatherLocation: Location): Boolean {
        return hasCustomLocationChanged(lastWeatherLocation)
    }

    override suspend fun getLocationString(): String {
        return "${getCustomLocationName()}"
    }

    private fun hasCustomLocationChanged(lastWeatherLocation: Location): Boolean {
        val customLocationName = getCustomLocationName()
        return customLocationName != lastWeatherLocation.name
    }

    private fun getCustomLocationName(): String? {
        return preferences.getString(CUSTOM_LOCATION, null)
    }
}
