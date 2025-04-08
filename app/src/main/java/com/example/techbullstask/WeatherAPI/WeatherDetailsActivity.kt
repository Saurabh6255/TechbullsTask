package com.example.techbullstask.WeatherAPI

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.techbullstask.R
import com.example.techbullstask.databinding.ActivityWeatherDetailsBinding

class WeatherDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherDetailsBinding
    private var forecastList: List<ForecastBean>? = null
    private lateinit var rvForecastAdapter: RvForecastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bean = intent.getSerializableExtra("Key") as? DataBean
        forecastList = intent.getSerializableExtra("forecastList") as? List<ForecastBean>

        bean?.let {
            binding.tvId.text = "Id: ${it.id}"
            binding.tvCity.text = "City: ${it.city}"
            binding.tvCountry.text = "Country: ${it.country}"
            binding.tvLatLong.text = "LatLong: ${it.latitude}, ${it.longitude}"
            binding.tvTemp.text = "Temperature: ${it.temperature}"
            binding.tvDesc.text = "Description: ${it.weather_description}"
            binding.tvHumidity.text = "Humidity: ${it.humidity}"
            binding.tvWindSpeed.text = "Wind Speed: ${it.wind_speed}"
        }

        if (!forecastList.isNullOrEmpty()) {
            rvForecastAdapter = RvForecastAdapter(this, forecastList!!)
            binding.rvForecast.layoutManager = LinearLayoutManager(this)
            binding.rvForecast.adapter = rvForecastAdapter
        } else {
            Toast.makeText(this, "No forecast data available", Toast.LENGTH_SHORT).show()
        }
    }
}