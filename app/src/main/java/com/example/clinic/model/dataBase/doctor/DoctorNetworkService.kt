package com.example.clinic.model.dataBase.doctor

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DoctorNetworkService(){

    companion object{
        var mRetrofit: Retrofit = TODO()
        val BASE_URL: String = "https://zeref.ru/clinicquerys/"

        private fun NetworkService() {

            mRetrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getJSONDoctor(): DoctorApi? {
            return mRetrofit.create<DoctorApi>(DoctorApi::class.java)
        }
    }
}