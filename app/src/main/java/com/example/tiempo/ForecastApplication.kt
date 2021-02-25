package com.example.tiempo

import android.app.Application
import com.example.tiempo.data.db.ForecastDatabase
import com.example.tiempo.data.network.ConnectivityInterceptor
import com.example.tiempo.data.network.WeatherNetworkDataSource
import com.example.tiempo.data.network.WeatherNetworkDataSourceImpl
import com.example.tiempo.data.network.WeatherService
import com.example.tiempo.data.repository.ForecastRepository
import com.example.tiempo.data.repository.ForecastRepositoryImpl
import com.example.tiempo.ui.current.CurrentWeatherViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ForecastApplication : Application(), KodeinAware {

    override fun onCreate() {
        super.onCreate()

    }

    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        bind() from singleton { ConnectivityInterceptor(instance()) }
        bind() from singleton { WeatherService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(), instance()) }
        bind() from provider { CurrentWeatherViewModelFactory(instance()) }
    }


}