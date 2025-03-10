package com.example.weather

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.data.WeatherRepository
import com.example.weather.ui.HomeScreen
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeScreenTest {

    private val mockRepository: WeatherRepository = mockk()
    private val viewModel = WeatherViewModel(mockRepository)

    @JvmField
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        coEvery {
            viewModel.repository.getWeatherOrNull(any())
        } returns FAKE_VALID_WEATHER_RESPONSE
    }

    @Test
    fun `test Home Screen`() {
        composeTestRule.run {
            setStandardContent()
            verifyWeather()
        }
    }

    private fun ComposeContentTestRule.setStandardContent() {
        setContent {
            HomeScreen(viewModel, {})
        }
    }

    private fun ComposeContentTestRule.verifyWeather() {
        onNodeWithText("Sunny").assertExists()
    }
}
