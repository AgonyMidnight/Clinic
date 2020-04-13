package com.example.clinic.model.dataBase.city

import androidx.room.*

interface CityDao {
    @Insert
    fun insertCity(city: City)

    @Delete
    fun deleteCity(city: City)

    @Update
    fun updateCity(city: City)

    @Query("select * from city")
    fun selectAllCity(): List<City>

    @Query("select * from city where id = :id")
    fun selectIdCity(id: Int): City

    @Query("select * from city where city_Name = :city_Name")
    fun selectCityName(city_Name: String): List<City>
}