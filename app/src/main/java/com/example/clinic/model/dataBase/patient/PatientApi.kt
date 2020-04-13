package com.example.clinic.model.dataBase.patient

import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface PatientApi {
    @GET("?zapros=get_patient_id")
    suspend fun getIdPatient(@Query("login") patient_login: String, @Query("pass") patient_pass: String): Patient

    @GET("?zapros=get_patient_info")
    suspend fun getPatientInfo(@Query("id") id: Int): Patient

    @GET("?zapros=set_newPatient")
    suspend fun setNewPatient(
        @Query("patient_firstName") patient_firstName: String,
        @Query("patient_secondName") patient_secondName: String,
        @Query("patient_addressNumber") patient_addressNumber: String,
        @Query("patient_addressStreet") patient_addressStreet: String,
        @Query("patient_phone") patient_phone: String,
        @Query("patient_birthday") patient_birthday: Date,
        @Query("patient_login") patient_login: String,
        @Query("patient_password") patient_password: String,
        @Query("patient_numberMedCard") patient_numberMedCard: String,
        @Query("patient_medPolice") patient_medPolice: String
    )

    @GET("?zapros=update_doctor")
    suspend fun updatePatient(
        @Query("id") id: Int,
        @Query("patient_firstName") patient_firstName: String,
        @Query("patient_secondName") patient_secondName: String,
        @Query("patient_addressNumber") patient_addressNumber: String,
        @Query("patient_addressStreet") patient_addressStreet: String,
        @Query("patient_phone") patient_phone: String,
        @Query("patient_birthday") patient_birthday: Date,
        @Query("patient_login") patient_login: String,
        @Query("patient_password") patient_password: String,
        @Query("patient_numberMedCard") patient_numberMedCard: String,
        @Query("patient_medPolice") patient_medPolice: String
    )

}