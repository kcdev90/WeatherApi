package com.example.weather

import com.example.data.Main
import com.example.data.Weather
import com.example.data.WeatherResponse
import com.example.data.Wind

public val FAKE_VALID_WEATHER_RESPONSE = WeatherResponse(
    weather = listOf(
        Weather(
            main = "Sunny",
            description = "Sunny with partial clouds"
        )
    ),
    main = Main(
        temp = 70.0,
        feelsLike = 69.9,
        tempMin = 60.0,
        tempMax = 80.0,
        humidity = 50,
    ),
    wind = Wind(
        speed = 10.0
    ),
    rain = null
)
