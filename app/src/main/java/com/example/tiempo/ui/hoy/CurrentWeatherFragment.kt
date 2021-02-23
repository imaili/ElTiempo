package com.example.tiempo.ui.hoy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.tiempo.R
import com.example.tiempo.data.network.ConnectivityInterceptor
import com.example.tiempo.data.network.WeatherNetworkDataSourceImpl
import com.example.tiempo.data.network.WeatherService
import kotlinx.android.synthetic.main.fragment_current_weather.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentWeatherFragment : Fragment() {

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_current_weather, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel::class.java)
        val apiService = WeatherService(ConnectivityInterceptor(this.requireContext()))
        val weatherNetworkDataSource = WeatherNetworkDataSourceImpl(apiService)

        weatherNetworkDataSource.downloadedCurrentWeather.observe(viewLifecycleOwner, Observer {
            text_home.text = it.toString()
        })

        GlobalScope.launch {
            weatherNetworkDataSource.fetchCurrentWeather("London")
        }

    }



}