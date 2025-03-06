package com.example.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepository {

    // Inject into constructor via Hilt in PROD
    private val weatherSource = RemoteWeatherSource()

    suspend fun getWeatherOrNull(city: City) = withContext(Dispatchers.IO) {
        try {
            weatherSource.getWeather(city)
        } catch (e: Exception) {
            Log.e("null", "exception = $e")
            // Fire monitoring (NR, Splunk, etc.) events
            null
        }
    }
}
