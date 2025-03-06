package com.example.weather.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weather.WeatherViewModel
import com.example.weather.WeatherViewModel.CityDetails

@Composable
internal fun HomeScreen(viewModel: WeatherViewModel) {
    val viewState by viewModel.viewState.collectAsState()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(viewState.cities) { city ->
            WeatherSummary(city)
        }
    }
}

@Composable
private fun WeatherSummary(city: CityDetails) {
    Card(
        onClick = {},
        shape = CardDefaults.elevatedShape,
        colors = CardDefaults.elevatedCardColors(),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(city.name)
    }
}
