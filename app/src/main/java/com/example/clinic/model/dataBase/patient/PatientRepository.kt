package com.example.clinic.model.dataBase.patient

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.clinic.model.dataBase.ClinicDataBase

class PatientRepository (
    context: Context,
    clinicDataBase: ClinicDataBase
) {
    private val patientDao = clinicDataBase.patientDao()

    fun getPatientID(doctor_id: Int): Patient {
        return patientDao.selectIdPatient(doctor_id)
    }

    fun getPatientsAll(): LiveData<List<Patient>> {
        return patientDao.selectAllPatient()
    }

    fun getPatientsSecondName(doctor_secondName: String): LiveData<List<Patient>>{
        return patientDao.selectSecondNamePatient(doctor_secondName)
    }

    fun getPatientsFirstName(doctor_firstName: String): LiveData<List<Patient>>{
        return patientDao.selectFirstNamePatient(doctor_firstName)
    }

    fun getPatientsFullName(doctor_firstName: String, doctor_secondName: String): LiveData<List<Patient>>{
        return patientDao.selectFullNamePatient(doctor_firstName, doctor_secondName)
    }

    fun insertPatient(doctor: Patient){
        patientDao.insertDoc(doctor)
    }

    fun deletePatient(doctor: Patient){
        patientDao.deleteDoc(doctor)
    }

    fun updatePatient(doctor: Patient){
        patientDao.updateDoc(doctor)
    }
}