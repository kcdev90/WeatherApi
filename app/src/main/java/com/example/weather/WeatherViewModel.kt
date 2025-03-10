package com.example.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.City
import com.example.data.WeatherRepository
import com.example.weather.model.CityDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel(
    internal val repository: WeatherRepository = WeatherRepository()
) : ViewModel() {

    data class ViewState(
        val cities: MutableList<CityDetails> = mutableListOf()
    )

    private val _viewState = MutableStateFlow(ViewState())
    val viewState = _viewState.asStateFlow()

    init {
        loadWeather()
    }

    internal fun loadWeather() {
        // TODO: Store in SharedPreferences?
        val myCities = City.entries

        viewModelScope.launch {
            // Open Weather API doesn't support bulk request
            myCities.forEach { city ->
                repository.getWeatherOrNull(city)?.let { response ->
                    _viewState.update { state ->
                        val newCity = CityDetails(
                            name = city.friendlyName,
                            weather = response.weather[0].main,
                            weatherDescription = response.weather[0].description,
                            temperature = response.main.temp,
                            feelsLike = response.main.feelsLike,
                            low = response.main.tempMin,
                            high = response.main.tempMax,
                            humidity = response.main.humidity,
                            wind = response.wind.speed,
                            rain = response.rain?.oneHour
                        )

                        // NB: Need to create new reference for state.cities
                        // for the UI to get updated!
                        val cities = mutableListOf<CityDetails>()
                        cities.addAll(state.cities)
                        cities.add(newCity)
                        state.copy(cities = cities)
                    }
                }
            }
        }
    }
}
