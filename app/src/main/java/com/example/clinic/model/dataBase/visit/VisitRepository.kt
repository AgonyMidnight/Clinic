package com.example.clinic.model.dataBase.visit

import android.content.Context
import com.example.clinic.model.dataBase.ClinicDataBase
import java.util.*

class VisitRepository (context: Context) {
    private val clinicDataBase = ClinicDataBase(context)
    private val visitDao = clinicDataBase.visitDao()

    suspend fun getVisitID(doctor_id: Int): Visit = visitDao.selectIdVisits(doctor_id)

    suspend fun getVisitsAll(): List<Visit> = visitDao.selectAllVisits()

    suspend fun getVisitsDate(visit_date: Date):List<Visit> = visitDao.selectDateVisits(visit_date)

    suspend fun getVisitcomplaints(visit_complaints: String): List<Visit> = visitDao.selectComplaintsVisits(visit_complaints)

    suspend fun getVisitsassignment(visit_assignment: String): List<Visit> = visitDao.selectAssignmentsVisits(visit_assignment)

    suspend fun getVisitDoctorID(doctor_id: Int): Visit = visitDao.selectIdVisits(doctor_id)

    suspend fun getVisitPatientID(patient_id: Int): Visit = visitDao.selectIdVisits(patient_id)

    suspend fun getNoSpendVisitbyDoctor(doctor_id: Int): List<Visit> = visitDao.selectNoSpendVisitbyDoctor(doctor_id)

    suspend fun getSpendVisitbyDoctor(doctor_id: Int): List<Visit> = visitDao.selectSpendVisitbyDoctor(doctor_id)

    suspend fun getNoSpendVisitbyPatient(patient_id: Int): List<Visit> = visitDao.selectNoSpendVisitbyPatient(patient_id)

    suspend fun getSpendVisitbyPatient(patient_id: Int): List<Visit> = visitDao.selectSpendVisitbyPatient(patient_id)

    suspend fun insertVisit(doctor: Visit) = visitDao.insertDoc(doctor)

    suspend fun deleteVisit(doctor: Visit) = visitDao.deleteDoc(doctor)

    suspend fun updateVisit(doctor: Visit) = visitDao.updateDoc(doctor)
}