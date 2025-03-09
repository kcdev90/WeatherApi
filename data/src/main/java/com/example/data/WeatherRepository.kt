package com.example.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepository(
    // Inject into constructor via Hilt in PROD
    internal val weatherSource: RemoteWeatherSource = RemoteWeatherSource()
) {

    suspend fun getWeatherOrNull(city: City) = withContext(Dispatchers.IO) {
        weatherSource.getWeather(city).also {
            if (it == null) {
                someErrorHandlingFunction()
            }
        }
    }

    internal fun someErrorHandlingFunction() {
        // Fire monitoring (NR, Splunk, etc.) events
        Log.e(WeatherRepository::class.simpleName, "Oh no! I couldn't get weather info! :(")
    }
}
