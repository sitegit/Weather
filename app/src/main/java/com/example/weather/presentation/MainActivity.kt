package com.example.weather.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.weather.data.network.api.ApiFactory
import com.example.weather.presentation.ui.theme.WeatherTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val apiService = ApiFactory.apiService

        lifecycleScope.launch(Dispatchers.Main) {
            val currentWeather = apiService.loadCurrentWeather("Москва")
            val forecastWeather = apiService.loadForecast("Москва")
            val searchCity = apiService.searchCity("Москва")

            Log.i("MyTag", "currentWeather: $currentWeather")
            Log.i("MyTag", "forecastWeather: $forecastWeather")
            Log.i("MyTag", "searchCity: $searchCity")
        }

        setContent {
            WeatherTheme {

            }
        }
    }
}
