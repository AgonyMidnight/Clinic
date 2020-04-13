package com.example.clinic.model.dataBase.doctor

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DoctorNetworkService {
    lateinit var retrofit: Retrofit
    val BASE_URL: String = "https://zeref.ru/clinicquerys/"

    private fun NetworkService() {

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun doctorApi(): DoctorApi {
        return retrofit.create<DoctorApi>(DoctorApi::class.java)
    }
}