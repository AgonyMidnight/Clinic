package com.example.clinic.model.dataBase.doctor

import okhttp3.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*
import retrofit2.Call as Retrofit2Call

interface DoctorApi {
    @GET("?zapros=get_doctor_bySpec")
    fun getSpecializationDoctor(@Query("id") id: Int): Call

    @GET("?zapros=get_doctor_info")
    fun getIdDoctor(@Query("login") doctor_login: String, @Query("pass") doctor_pass: String): Call

    @GET("?zapros=get_doctor_bySpec")
    fun getDoctorBySpec(@Query("id") id: String): Call

    @GET("?zapros=get_All_Doctor")
    fun getAllDoctor(): Call

    @GET("?zapros=set_newDoctor")
    fun setNewDoctor(
        @Query("doctor_firstName") doctor_firstName: String,
        @Query("doctor_secondName") doctor_secondName: String,
        @Query("doctor_passport") doctor_passport: String,
        @Query("doctor_TIN") doctor_TIN: String,
        @Query("doctor_phone") doctor_phone: String,
        @Query("doctor_birthday") doctor_birthday: Date,
        @Query("doctor_login") doctor_login: String,
        @Query("doctor_password") doctor_password: String
    )

    @GET("?zapros=update_doctor")
    fun updateDoctor(
        @Query("doctor_firstName") doctor_firstName: String,
        @Query("doctor_secondName") doctor_secondName: String,
        @Query("doctor_passport") doctor_passport: String,
        @Query("doctor_TIN") doctor_TIN: String,
        @Query("doctor_phone") doctor_phone: String,
        @Query("doctor_birthday") doctor_birthday: Date,
        @Query("doctor_login") doctor_login: String,
        @Query("doctor_password") doctor_password: String
    )
}