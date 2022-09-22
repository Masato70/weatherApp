package com.example.weatherapp

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.weatherapp.ui.theme.WeatherAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var list = weatherTask()
            Log.d(TAG, list.toString())
            Log.d(TAG, "通過5")
            WeatherAppTheme {
                if (list != null) {
                    WeatherDisplay(list)
                }

            }
        }
    }


}

