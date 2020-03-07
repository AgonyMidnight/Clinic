package com.example.clinic.model.dataBase.visit

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.clinic.model.dataBase.ClinicDataBase
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.util.*

class VisitRepository (context: Context) {
    private val clinicDataBase = ClinicDataBase(context)
    private val visitDao = clinicDataBase.visitDao()

    fun getVisitID(doctor_id: Int): Deferred<Visit> = GlobalScope.async {
        return@async visitDao.selectIdVisits(doctor_id)
    }

    /*fun getVisitID(doctor_id: Int): Visit {
        var visit: Visit
        GlobalScope.async {
            visit = visitDao.selectIdVisits(doctor_id)
        }
        return visit
    }*/

    fun getVisitsAll(): Deferred<LiveData<List<Visit>>> = GlobalScope.async{
        return@async visitDao.selectAllVisits()
    }

    fun getVisitsDate(visit_date: Date): Deferred<LiveData<List<Visit>>> = GlobalScope.async{
        return@async visitDao.selectDateVisits(visit_date)
    }

    fun getVisitcomplaints(visit_complaints: String): Deferred<LiveData<List<Visit>>> = GlobalScope.async{
        return@async visitDao.selectComplaintsVisits(visit_complaints)
    }

    fun getVisitsassignment(visit_assignment: String): Deferred<LiveData<List<Visit>>> = GlobalScope.async{
        return@async visitDao.selectAssignmentsVisits(visit_assignment)
    }

    fun getVisitDoctorID(doctor_id: Int): Deferred<Visit> = GlobalScope.async {
        return@async visitDao.selectIdVisits(doctor_id)
    }

    fun getVisitPatientID(patient_id: Int): Deferred<Visit> = GlobalScope.async {
        return@async visitDao.selectIdVisits(patient_id)
    }

    fun insertVisit(doctor: Visit) = GlobalScope.async{
        visitDao.insertDoc(doctor)
    }

    fun deleteVisit(doctor: Visit) = GlobalScope.async{
        visitDao.deleteDoc(doctor)
    }

    fun updateVisit(doctor: Visit) = GlobalScope.async{
        visitDao.updateDoc(doctor)
    }
}