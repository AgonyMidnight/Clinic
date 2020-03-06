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

    fun getCityID(specialization_id: Int): Deferred<City> = GlobalScope.async {
        return@async cityDao.selectIdCity(specialization_id)
    }

    fun getNameCity(specialization_name: String): Deferred<LiveData<List<City>>> = GlobalScope.async {
        return@async cityDao.selectCityName(specialization_name)
    }

    fun getAllCity(): Deferred<LiveData<List<City>>> = GlobalScope.async {
        return@async cityDao.selectAllCity()
    }

    fun insertCity(city: City) = GlobalScope.async{
        cityDao.insertCity(city)
    }

    fun deleteCity(city: City) = GlobalScope.async{
        cityDao.deleteCity(city)
    }

    fun updateCity(doctor: City) = GlobalScope.async{
        cityDao.updateCity(doctor)
    }
}