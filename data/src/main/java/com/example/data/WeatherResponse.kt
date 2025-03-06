package com.example.data

import com.google.gson.annotations.SerializedName

public data class WeatherResponse(
    val weather: List<Weather>,
    val main: Main,
    val wind: Wind,
    val rain: Rain?
)

public data class Weather(
    @SerializedName("main") val main: String,
    @SerializedName("description") val description: String,
)

public data class Main(
    @SerializedName("temp") val temp: Double,
    @SerializedName("feels_like") val feelsLike: Double,
    @SerializedName("temp_min") val tempMin: Double,
    @SerializedName("temp_max") val tempMax: Double,
    @SerializedName("humidity") val humidity: Int,
)

public data class Wind(
    @SerializedName("speed") val speed: Double
)

public data class Rain(
    @SerializedName("1h") val oneHour: Double
)
