package com.example.weather.navigation

import com.example.weather.model.CityDetails
import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

@Serializable
data class CityDetailsRoute(val cityDetails: CityDetails)
