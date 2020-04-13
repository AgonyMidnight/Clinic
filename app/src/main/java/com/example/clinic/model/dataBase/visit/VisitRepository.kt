package com.example.clinic.model.dataBase.visit

import android.content.Context
import com.example.clinic.model.dataBase.ClinicDataBase
import java.util.*

class VisitRepository(context: Context) {
    private val clinicDataBase = ClinicDataBase(context)
    private val visitDao = clinicDataBase.visitDao()
    private var errorFlagVisitApi = false

    suspend fun getVisitByDoctor(id: Int) {
        try {
            val visit = VisitNetworkService.visitApi().getVisitByDoctor(id)
        } catch (e: Throwable) {
            errorFlagVisitApi = true
        }
    }

    suspend fun getVisitByPatient(id: Int) {
        try {
            val visit = VisitNetworkService.visitApi().getVisitByPatient(id)
        } catch (e: Throwable) {
            errorFlagVisitApi = true
        }
    }

    suspend fun getNoSpendVisitByDoctor(id: Int) {
        try {
            val visit = VisitNetworkService.visitApi().getNoSpendVisitByDoctor(id)
        } catch (e: Throwable) {
            errorFlagVisitApi = true
        }
    }

    suspend fun getSpendVisitByDoctor(id: Int) {
        try {
            val visit = VisitNetworkService.visitApi().getSpendVisitByDoctor(id)
        } catch (e: Throwable) {
            errorFlagVisitApi = true
        }
    }

    suspend fun getNoSpendVisitByPatient(id: Int) {
        try {
            val visit = VisitNetworkService.visitApi().getNoSpendVisitByPatient(id)
        } catch (e: Throwable) {
            errorFlagVisitApi = true
        }
    }

    suspend fun getSpendVisitByPatient(id: Int) {
        try {
            val visit = VisitNetworkService.visitApi().getSpendVisitByPatient(id)
        } catch (e: Throwable) {
            errorFlagVisitApi = true
        }
    }

    suspend fun getNearestVisitByDoctor(id: Int) {
        try {
            val visit = VisitNetworkService.visitApi().getNearestVisitByDoctor(id)
        } catch (e: Throwable) {
            errorFlagVisitApi = true
        }
    }

    suspend fun getNearestVisitByPatient(id: Int) {
        try {
            val visit = VisitNetworkService.visitApi().getNearestVisitByPatient(id)
        } catch (e: Throwable) {
            errorFlagVisitApi = true
        }
    }

    suspend fun getScheduleDayByDoctor(id: Int) {
        try {
            val visit = VisitNetworkService.visitApi().getScheduleDayByDoctor(id)
        } catch (e: Throwable) {
            errorFlagVisitApi = true
        }
    }

    suspend fun insertVisit(
        visit_date: Date,
        visit_complaints: String,
        visit_assignment: String,
        visit_comments: String,
        doctor_id: Int,
        patient_id: Int
    ) {
        try {
            VisitNetworkService.visitApi().setNewVisit(
                visit_date,
                visit_complaints,
                visit_assignment,
                visit_comments,
                doctor_id,
                patient_id
            )
        } catch (e: Throwable) {
            errorFlagVisitApi = true
        }
    }

    suspend fun insertVisit(
        id: Int,
        visit_date: Date,
        visit_complaints: String,
        visit_assignment: String,
        visit_comments: String,
        doctor_id: Int,
        patient_id: Int
    ) {
        try {
            VisitNetworkService.visitApi().setUpdateVisit(
                id,
                visit_date,
                visit_complaints,
                visit_assignment,
                visit_comments,
                doctor_id,
                patient_id
            )
        } catch (e: Throwable) {
            errorFlagVisitApi = true
        }
    }
}