package com.example.clinic.model.dataBase.patient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PatientNetworkService {
    lateinit var retrofit: Retrofit
    val BASE_URL: String = "https://zeref.ru/clinicquerys/"

    private fun NetworkService() {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun patientApi(): PatientApi {
        return retrofit.create<PatientApi>(PatientApi::class.java)
    }
}