package com.example.weather.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weather.WeatherViewModel
import com.example.weather.model.CityDetails
import com.example.weather.navigation.CityDetailsRoute

@Composable
internal fun HomeScreen(
    viewModel: WeatherViewModel,
    onCityClick: (CityDetails) -> Unit
//    navController: NavController
) {
    val viewState by viewModel.viewState.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.Top
    ) {
        items(viewState.cities) { cityDetails ->
            WeatherSummary(cityDetails, onCityClick)
        }
    }
}

@Composable
private fun WeatherSummary(
    cityDetails: CityDetails,
    onCityClick: (CityDetails) -> Unit
) {
    Card(
        onClick = {
            onCityClick(cityDetails)
//            navController.navigate(
//                CityDetailsRoute(cityDetails = cityDetails)
//            )
        },
        shape = CardDefaults.elevatedShape,
        colors = CardDefaults.elevatedCardColors(),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(cityDetails.name)
                Text(cityDetails.weather)
            }
            Text("${cityDetails.temperature} F")
        }
    }
}
