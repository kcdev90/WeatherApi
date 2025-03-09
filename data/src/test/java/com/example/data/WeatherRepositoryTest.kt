package com.example.data

import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertIs
import kotlin.test.assertNull

class WeatherRepositoryTest {

    private val mockWeatherSource: RemoteWeatherSource = mockk()
    private val repositorySpy = spyk(WeatherRepository(mockWeatherSource))

    @Test
    fun `WeatherRepository$getWeatherOrNull call returns valid response`() = runTest {
        coEvery { mockWeatherSource.getWeather(any()) } returns FAKE_VALID_WEATHER_RESPONSE

        val response = repositorySpy.getWeatherOrNull(City.NEW_YORK)
        assertIs<WeatherResponse>(response)
    }

    @Test
    fun `WeatherRepository$getWeatherOrNull fails`() = runTest {
        coEvery { mockWeatherSource.getWeather(any()) } returns null
        every { repositorySpy.someErrorHandlingFunction() } just Runs

        val response = repositorySpy.getWeatherOrNull(City.NEW_YORK)
        assertNull(response)
        verify { repositorySpy.someErrorHandlingFunction() }
    }
}
