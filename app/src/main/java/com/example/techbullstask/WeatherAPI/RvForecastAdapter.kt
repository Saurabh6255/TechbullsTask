package com.example.techbullstask.WeatherAPI

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.techbullstask.databinding.WeatherlistBinding

class RvForecastAdapter(
    private val context: Context,
    private val list: List<ForecastBean>
) : RecyclerView.Adapter<RvForecastAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: WeatherlistBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = WeatherlistBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.binding.tvId.text = "Date: ${item.date}"
        holder.binding.tvCity.visibility = View.GONE
        holder.binding.tvCountry.visibility = View.GONE
        holder.binding.tvLatLong.visibility = View.GONE
        holder.binding.tvTemp.text = "Temperature: ${item.temperature}"
        holder.binding.tvDesc.text = "Description: ${item.weather_description}"
        holder.binding.tvHumidity.text = "Humidity: ${item.humidity}"
        holder.binding.tvWindSpeed.text = "Wind Speed: ${item.wind_speed}"
        holder.binding.ivArrow.visibility = View.GONE
    }

    override fun getItemCount(): Int = list.size
}