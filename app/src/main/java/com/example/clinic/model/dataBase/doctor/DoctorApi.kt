package com.example.clinic.model.dataBase.doctor

import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface DoctorApi {

    @GET("?zapros=get_goctor_id")
    suspend fun getIdDoctor(@Query("login") doctor_login: String, @Query("pass") doctor_pass: String): Doctor

    @GET("?zapros=get_doctor_info")
    suspend fun getDoctorInfo(@Query("id") id: Int): Doctor

    @GET("?zapros=get_doctor_bySpec")
    suspend fun getDoctorBySpec(@Query("id") id: Int): List<Doctor>

    @GET("?zapros=get_All_Doctor")
    suspend fun getAllDoctor(): List<Doctor>

    @GET("?zapros=set_newDoctor")
    suspend fun setNewDoctor(
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
    suspend fun updateDoctor(
        @Query("id") id: Int,
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