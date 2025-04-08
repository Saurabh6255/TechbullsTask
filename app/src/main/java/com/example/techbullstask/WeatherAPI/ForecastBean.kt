package com.example.techbullstask.WeatherAPI

import java.io.Serializable

data class ForecastBean(
    val date: String?,
    val temperature: Float?,
    val weather_description: String?,
    val humidity: Int?,
    val wind_speed: Float?
) : Serializable
