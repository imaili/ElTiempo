package com.example.tiempo.data

import com.example.tiempo.data.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "316c2740c91c060febe2ffd81197e7a0"

//http://api.weatherstack.com/current?access_key=316c2740c91c060febe2ffd81197e7a0&query=Yecla
interface WeatherService {

    @GET(value = "current")
    fun getCurrentWeather(
        @Query(value = "query") location : String

    ) : Deferred<CurrentWeatherResponse>


    companion object {
        operator fun invoke(): WeatherService {
            val requestInterceptor = Interceptor {

                val url = it.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key", API_KEY)
                    .build()
                val request = it.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor it.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.weatherstack.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherService::class.java)
        }
    }


}