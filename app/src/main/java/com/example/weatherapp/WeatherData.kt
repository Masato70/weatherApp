package com.example.weatherapp

import androidx.compose.runtime.Composable
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

data class WeatherData(
    var db: Int,
    var temp_min: Int,
    var temp_max: Int,
    var pop: Int,
    var icon: String
)