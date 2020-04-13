package com.example.clinic.model.dataBase.visit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object VisitNetworkService {
    lateinit var retrofit: Retrofit
    val BASE_URL: String = "https://zeref.ru/clinicquerys/"

    private fun NetworkService() {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun visitApi(): VisitApi {
        return retrofit.create<VisitApi>(VisitApi::class.java)
    }
}