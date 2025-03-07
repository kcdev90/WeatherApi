package com.example.weather.model

import kotlinx.serialization.Serializable

@Serializable
data class CityDetails(
    val name: String,
    val weather: String,
    val weatherDescription: String,
    val temperature: Double,
    val feelsLike: Double,
    val low: Double,
    val high: Double,
    val humidity: Int,
    val wind: Double,
    val rain: Double?
)
