package com.example.techbullstask.WeatherAPI

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.techbullstask.databinding.WeatherlistBinding
import java.io.Serializable

class RvWeatherAdapter(
    private val context: Context,
    private val list: List<DataBean>
) : RecyclerView.Adapter<RvWeatherAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: WeatherlistBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = WeatherlistBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.binding.tvId.text = "Id: ${item.id}"
        holder.binding.tvCity.text = "City: ${item.city}"
        holder.binding.tvCountry.text = "Country: ${item.country}"
        holder.binding.tvLatLong.text = "LatLong: ${item.latitude},${item.longitude}"
        holder.binding.tvTemp.text = "Temperature: ${item.temperature}"
        holder.binding.tvDesc.text = "Description: ${item.weather_description}"
        holder.binding.tvHumidity.text = "Humidity: ${item.humidity}"
        holder.binding.tvWindSpeed.text = "Wind Speed: ${item.wind_speed}"

        holder.itemView.setOnClickListener {
            val intent = Intent(context, WeatherDetailsActivity::class.java)
            intent.putExtra("Key", item)
            intent.putExtra("forecastList", item.forecast as Serializable)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = list.size
}
