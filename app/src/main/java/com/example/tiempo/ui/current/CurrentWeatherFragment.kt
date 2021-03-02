package com.example.tiempo.ui.current

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.tiempo.ForecastApplication
import com.example.tiempo.R
import com.example.tiempo.data.network.ConnectivityInterceptor
import com.example.tiempo.data.network.WeatherNetworkDataSourceImpl
import com.example.tiempo.data.network.WeatherService
import com.example.tiempo.ui.base.ScopedFragment
import kotlinx.android.synthetic.main.fragment_current_weather.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class CurrentWeatherFragment : ScopedFragment(), KodeinAware {

    private lateinit var viewModel: CurrentWeatherViewModel
    override val kodein by closestKodein()

    private val viewModelFactory: CurrentWeatherViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_current_weather, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CurrentWeatherViewModel::class.java)

        bindUI()


    }

    private fun bindUI() = launch {
        val currentWeather = viewModel.weather.await()
        currentWeather.observe(viewLifecycleOwner, Observer {
            if(it == null) return@Observer

            group_loading.visibility = View.GONE
            updateLocation("Los Angeles")
            updateDateToToday()
            updateTemperatures(it.temperature, it.feelslike)
            updateCondition(it.weatherDescription)
            updatePrecipitation(it.precip)
            updateWind(it.windDir, it.windSpeed)
            updateVisibility(it.visibility)

            Glide.with(this@CurrentWeatherFragment)
                .load("https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0001_sunny.png")
                .into(imageView_condition_icon)



        })
    }

    private fun updateVisibility(vis: Int) {

    }


    private fun updateLocation(location: String) {
        (activity as? AppCompatActivity)?.supportActionBar?.title = location
    }

    private fun updateDateToToday() {
        (activity as? AppCompatActivity)?.supportActionBar?.subtitle = "Today"
    }

    private fun updateTemperatures(temperature: Int, feelsLike: Int) {
        textView_temperature.text = "${temperature}ºC"
        textView_feels_like_temperature.text = "Feels like ${feelsLike}ºC"
    }

    private fun updateCondition(condition: String) {
        textView_condition.text = condition
    }

    private fun updatePrecipitation(precipitationVolume: Int) {

        textView_precipitation.text = "Preciptiation: $precipitationVolume mm"
    }

    private fun updateWind(windDirection: String, windSpeed: Int) {

        textView_wind.text = "Wind: $windDirection, $windSpeed kph"
    }






    }