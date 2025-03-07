package com.example.weather.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.example.weather.model.CityDetails
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object CityDetailsNavType {

    val CityDetailsType = object : NavType<CityDetails>(
        isNullableAllowed = false
    ) {

        override fun get(bundle: Bundle, key: String): CityDetails? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): CityDetails {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun put(bundle: Bundle, key: String, value: CityDetails) {
            bundle.putString(key, Json.encodeToString(value))
        }

        override fun serializeAsValue(value: CityDetails): String {
            return Uri.encode(Json.encodeToString(value))
        }
    }
}
