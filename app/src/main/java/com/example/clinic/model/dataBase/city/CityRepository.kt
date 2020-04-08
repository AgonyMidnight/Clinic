package com.example.clinic.model.dataBase.city

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.clinic.model.dataBase.ClinicDataBase
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class CityRepository (context: Context){
    private val clinicDataBase = ClinicDataBase(context)
    private val cityDao = clinicDataBase.cityDao()

    fun getCityID(specialization_id: Int): City = cityDao.selectIdCity(specialization_id)

    fun getNameCity(specialization_name: String): List<City> = cityDao.selectCityName(specialization_name)

    fun getAllCity(): List<City> = cityDao.selectAllCity()

    fun insertCity(city: City) = cityDao.insertCity(city)

    fun deleteCity(city: City) = cityDao.deleteCity(city)

    fun updateCity(doctor: City) = cityDao.updateCity(doctor)
}