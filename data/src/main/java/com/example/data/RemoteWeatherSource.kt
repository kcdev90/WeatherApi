package com.example.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// DO NOT store API keys in plain text!
private const val API_KEY = "810e002de92ac3b8789c5377ce288bb7"

class RemoteWeatherSource {

    // Inject into constructor via Hilt in PROD
    private val api = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WeatherApi::class.java)

    suspend fun getWeather(city: City): WeatherResponse? =
        api.getWeather(
            lat = city.lat,
            lon = city.lon,
            apiKey = API_KEY
        )
}
