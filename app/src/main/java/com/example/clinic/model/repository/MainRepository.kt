package com.example.clinic.model.repository

import android.content.Context
import com.example.clinic.model.dataBase.ClinicDataBase
import com.example.clinic.model.dataBase.doctor.DoctorRepository
import com.example.clinic.model.dataBase.patient.PatientRepository
import com.example.clinic.model.dataBase.visit.VisitRepository

class MainRepository(context: Context) {
    private val clinicDataBase = ClinicDataBase(context)
    private val visitRepository = VisitRepository(context)
    private val patientRepository = PatientRepository(context)
    private val doctorRepository = DoctorRepository(context)




}