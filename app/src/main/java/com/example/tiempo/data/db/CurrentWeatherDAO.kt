package com.example.tiempo.data.db


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tiempo.data.db.entity.CURRENT_WEATHER_ID
import com.example.tiempo.data.db.entity.CurrentWeather
import com.example.tiempo.data.db.entity.CurrentWeatherEntry


@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weatherEntry: CurrentWeather)

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeather(): LiveData<CurrentWeather>


}