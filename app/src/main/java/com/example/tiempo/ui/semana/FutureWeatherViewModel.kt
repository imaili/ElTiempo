package com.example.tiempo.ui.semana

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FutureWeatherViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Esta es la ventana del tiempo de la proxima semana"
    }
    val text: LiveData<String> = _text
}