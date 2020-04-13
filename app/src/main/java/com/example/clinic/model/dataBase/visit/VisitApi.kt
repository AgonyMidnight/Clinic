package com.example.clinic.model.dataBase.visit

import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface VisitApi {
    @GET("?zapros=get_visit_byDoctor")
    suspend fun getVisitByDoctor(@Query("id") idDoctor: Int): Visit

    @GET("?zapros=get_visit_byPatient")
    suspend fun getVisitByPatient(@Query("id") idPatient: Int): Visit

    @GET("?zapros=get_noSpendVisit_byDoctor")
    suspend fun getNoSpendVisitByDoctor(@Query("id") idDoctor: Int): Visit

    @GET("?zapros=get_spendVisit_byDoctor")
    suspend fun getSpendVisitByDoctor(@Query("id") idDoctor: Int): Visit

    @GET("?zapros=get_noSpendVisit_byPatient")
    suspend fun getNoSpendVisitByPatient(@Query("id") idPatient: Int): Visit

    @GET("?zapros=get_SpendVisit_byPatient")
    suspend fun getSpendVisitByPatient(@Query("id") idPatient: Int): Visit

    @GET("?zapros=get_nearestVisit_byDoctor")
    suspend fun getNearestVisitByDoctor(@Query("id") idDoctor: Int): Visit

    @GET("?zapros=get_nearestVisit_byPatient")
    suspend fun getNearestVisitByPatient(@Query("id") idPatient: Int): Visit

    @GET("?zapros=get_scheduleByDay")
    suspend fun getScheduleDayByDoctor(@Query("id") idDoctor: Int): List<Visit>

    @GET("?zapros=update_visit")
    suspend fun setUpdateVisit(
        @Query("id") id: Int,
        @Query("visit_date") visit_date: Date,
        @Query("visit_complaints") visit_complaints: String,
        @Query("visit_assignment") visit_assignment: String,
        @Query("visit_comments") visit_comments: String,
        @Query("doctor_id") doctor_id: Int,
        @Query("patient_id") patient_id: Int
    )

    @GET("?zapros=set_newVisit")
    suspend fun setNewVisit(
        @Query("visit_date") visit_date: Date,
        @Query("visit_complaints") visit_complaints: String,
        @Query("visit_assignment") visit_assignment: String,
        @Query("visit_comments") visit_comments: String,
        @Query("doctor_id") doctor_id: Int,
        @Query("patient_id") patient_id: Int
        )
}