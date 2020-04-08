package com.example.clinic.model.dataBase.patient

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.clinic.model.dataBase.ClinicDataBase
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class PatientRepository (context: Context) {
    private val clinicDataBase = ClinicDataBase(context)
    private val patientDao = clinicDataBase.patientDao()

    suspend fun getPatientID(doctor_id: Int): Patient = patientDao.selectIdPatient(doctor_id)

    suspend fun getPatientsAll(): List<Patient> = patientDao.selectAllPatient()

    suspend fun getPatientsSecondName(doctor_secondName: String): List<Patient> = patientDao.selectSecondNamePatient(doctor_secondName)

    suspend fun getPatientsFirstName(doctor_firstName: String): List<Patient> = patientDao.selectFirstNamePatient(doctor_firstName)

    suspend fun getPatientsFullName(doctor_firstName: String, doctor_secondName: String): List<Patient> = patientDao.selectFullNamePatient(doctor_firstName, doctor_secondName)

    suspend fun insertPatient(doctor: Patient) = patientDao.insertDoc(doctor)

    suspend fun deletePatient(doctor: Patient) = patientDao.deleteDoc(doctor)

    suspend fun updatePatient(doctor: Patient) = patientDao.updateDoc(doctor)
}