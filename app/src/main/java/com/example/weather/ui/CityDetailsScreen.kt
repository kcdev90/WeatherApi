package com.example.weather.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.weather.model.CityDetails

@Composable
internal fun CityDetailsScreen(cityDetails: CityDetails) {
    Text(cityDetails.name)
}
