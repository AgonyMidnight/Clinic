package com.example.clinic.model.dataBase.visit

import android.content.Context
import com.example.clinic.model.dataBase.ClinicDataBase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.util.*

class VisitRepository (context: Context) {
    private val clinicDataBase = ClinicDataBase(context)
    private val visitDao = clinicDataBase.visitDao()

    fun getVisitID(doctor_id: Int) = GlobalScope.async {
        return@async visitDao.selectIdVisits(doctor_id)
    }

    /*fun getVisitID(doctor_id: Int): Visit {
        var visit: Visit
        GlobalScope.async {
            visit = visitDao.selectIdVisits(doctor_id)
        }
        return visit
    }*/

    fun getVisitsAll(): List<Visit>{
        return visitDao.selectAllPatient()
    }

    fun getVisitsDate(visit_date: Date): List<Visit>{
        return visitDao.selectDatePatient(visit_date)
    }

    fun getVisitcomplaints(visit_complaints: String): List<Visit>{
        return visitDao.selectComplaintsPatient(visit_complaints)
    }

    fun getVisitsassignment(visit_assignment: String): List<Visit>{
        return visitDao.selectAssignmentsPatient(visit_assignment)
    }

    fun getVisitDoctorID(doctor_id: Int): Visit {
        return visitDao.selectIdVisits(doctor_id)
    }

    fun getVisitPatientID(patient_id: Int): Visit {
        return visitDao.selectIdVisits(patient_id)
    }

    fun insertVisit(doctor: Visit){
        visitDao.insertDoc(doctor)
    }

    fun deleteVisit(doctor: Visit){
        visitDao.deleteDoc(doctor)
    }

    fun updateVisit(doctor: Visit){
        visitDao.updateDoc(doctor)
    }
}