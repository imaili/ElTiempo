package com.example.tiempo.ui.semana

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.tiempo.R

class FutureWeatherFragment : Fragment() {

    private lateinit var tiempoSemanaViewModel: FutureWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tiempoSemanaViewModel =
            ViewModelProviders.of(this).get(FutureWeatherViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_future_weather, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        tiempoSemanaViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}