package com.example.tiempo.data.db

import com.example.tiempo.data.db.entity.CurrentWeatherEntry
import android.content.Context
import androidx.room.*
import com.example.tiempo.data.db.entity.CurrentWeather


@Database(
    entities = [CurrentWeather::class],
    version = 2
)

abstract class ForecastDatabase : RoomDatabase() {
    abstract fun currentWeatherDao(): CurrentWeatherDao

    companion object {
        @Volatile private var instance: ForecastDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ForecastDatabase::class.java, "forecast.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}