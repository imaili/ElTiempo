package com.example.tiempo.ui.hoy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.tiempo.R
import com.example.tiempo.data.WeatherService
import kotlinx.android.synthetic.main.fragment_current_weather.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentWeatherFragment : Fragment() {

    private lateinit var currentWeatherViewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        currentWeatherViewModel =
            ViewModelProviders.of(this).get(CurrentWeatherViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_current_weather, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        currentWeatherViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val apiService = WeatherService()
        GlobalScope.launch(Dispatchers.Main) {
            val response = apiService.getCurrentWeather("Madrid").await()
            text_home.text = response.toString()
        }
        return root
    }


}