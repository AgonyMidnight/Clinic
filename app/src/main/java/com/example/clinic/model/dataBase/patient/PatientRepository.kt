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

    fun getPatientID(doctor_id: Int): Deferred<Patient> = GlobalScope.async {
        return@async patientDao.selectIdPatient(doctor_id)
    }

    fun getPatientsAll(): Deferred<LiveData<List<Patient>>> = GlobalScope.async {
        return@async patientDao.selectAllPatient()
    }

    fun getPatientsSecondName(doctor_secondName: String): Deferred<LiveData<List<Patient>>> = GlobalScope.async{
        return@async patientDao.selectSecondNamePatient(doctor_secondName)
    }

    fun getPatientsFirstName(doctor_firstName: String): Deferred<LiveData<List<Patient>>> = GlobalScope.async{
        return@async patientDao.selectFirstNamePatient(doctor_firstName)
    }

    fun getPatientsFullName(doctor_firstName: String, doctor_secondName: String): Deferred<LiveData<List<Patient>>> = GlobalScope.async{
        return@async patientDao.selectFullNamePatient(doctor_firstName, doctor_secondName)
    }

    fun insertPatient(doctor: Patient) = GlobalScope.async{
        patientDao.insertDoc(doctor)
    }

    fun deletePatient(doctor: Patient) = GlobalScope.async{
        patientDao.deleteDoc(doctor)
    }

    fun updatePatient(doctor: Patient) = GlobalScope.async{
        patientDao.updateDoc(doctor)
    }
}