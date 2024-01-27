package com.example.weather.presentation.extentons

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnDestroy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

fun ComponentContext.componentScope(): CoroutineScope =
    CoroutineScope(Dispatchers.Main.immediate + SupervisorJob()).apply {
        lifecycle.doOnDestroy { cancel() }
    }