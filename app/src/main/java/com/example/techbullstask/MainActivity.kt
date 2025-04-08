package com.example.techbullstask

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.techbullstask.WeatherAPI.RvWeatherAdapter
import com.example.techbullstask.WeatherAPI.WeatherRepo
import com.example.techbullstask.WeatherAPI.WeatherViewModel
import com.example.techbullstask.WeatherAPI.WeatherViewModelFactory
import com.example.techbullstask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: WeatherViewModel
    private lateinit var rvWeatherAdapter: RvWeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pbHome.visibility = View.VISIBLE

//        viewModel = ViewModelProvider(this)[WeatherViewModel::class.java]

        val factory = WeatherViewModelFactory(this)
        viewModel = ViewModelProvider(this, factory)[WeatherViewModel::class.java]


        viewModel.getWeatherList().observe(this) { response ->
            if (response != null) {
                rvWeatherAdapter = RvWeatherAdapter(this, response)
                binding.rvWeatherList.layoutManager = LinearLayoutManager(this)
                binding.rvWeatherList.adapter = rvWeatherAdapter
                binding.pbHome.visibility = View.GONE
            } else {
                binding.pbHome.visibility = View.GONE
                Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }
}