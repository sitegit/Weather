package com.example.weather.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.example.weather.WeatherApplication
import com.example.weather.domain.usecase.ChangeFavouriteStateUseCase
import com.example.weather.domain.usecase.SearchCityUseCase
import com.example.weather.presentation.root.DefaultRootComponent
import com.example.weather.presentation.root.RootContent
import com.example.weather.presentation.ui.theme.WeatherTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var rootComponentFactory: DefaultRootComponent.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as WeatherApplication).applicationComponent.inject(this)
        super.onCreate(savedInstanceState)

        val root = rootComponentFactory.create(defaultComponentContext())

        setContent {
            WeatherTheme {
                RootContent(component = root)
            }
        }
    }
}
