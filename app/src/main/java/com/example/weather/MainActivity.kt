package com.example.weather

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.weather.model.CityDetails
import com.example.weather.navigation.CityDetailsNavType
import com.example.weather.navigation.CityDetailsRoute
import com.example.weather.navigation.HomeRoute
import com.example.weather.ui.CityDetailsScreen
import com.example.weather.ui.HomeScreen
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = HomeRoute
            ) {
                composable<HomeRoute> {
                    HomeScreen(
                        viewModel = WeatherViewModel(),
                        onCityClick = { city ->
                            navController.navigate(
                                CityDetailsRoute(cityDetails = city)
                            )
                        }
                    )
                }
                composable<CityDetailsRoute>(
                    typeMap = mapOf(
                        typeOf<CityDetails>() to CityDetailsNavType.CityDetailsType
                    )
                ) {
                    val args = it.toRoute<CityDetailsRoute>()
                    CityDetailsScreen(cityDetails = args.cityDetails)
                }
            }
        }
    }
}
