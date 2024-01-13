package com.example.weather.presentation.details

import com.arkivanov.decompose.ComponentContext

class DefaultDetailsComponent(
    private val componentContext: ComponentContext
) : DetailsComponent, ComponentContext by componentContext {

}