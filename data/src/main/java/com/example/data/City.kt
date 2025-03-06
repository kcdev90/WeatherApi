package com.example.data

public enum class City(
    val friendlyName: String,
    val lat: Double,
    val lon: Double
) {
    LOS_ANGELES(friendlyName = "Los Angeles", lat = 34.05, lon = 118.24),
    NEW_YORK(friendlyName = "New York", lat = 40.77, lon = 73.97),
    SAN_FRANCISCO(friendlyName = "San Francisco", lat = 37.47, lon = 122.25),
    SEATTLE(friendlyName = "Seattle", lat = 47.61, lon = 122.33)
}
