package com.example.clinic.model.dataBase.doctor

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.clinic.model.dataBase.ClinicDataBase
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class DoctorRepository (context: Context) {
    private val clinicDataBase = ClinicDataBase(context)
    private val doctorDao = clinicDataBase.doctorDao()

    fun getDoctorID(doctor_id: Int): Deferred<Doctor> = GlobalScope.async{
        return@async doctorDao.selectIdDoctor(doctor_id)
    }

    fun getDoctorsAll(): Deferred<LiveData<List<Doctor>>> = GlobalScope.async {
        return@async doctorDao.selectAllDoctor()
    }

    fun getDoctorsSecondName(doctor_secondName: String): Deferred<LiveData<List<Doctor>>> = GlobalScope.async{
        return@async doctorDao.selectSecondNameDoctor(doctor_secondName)
    }

    fun getDoctorFirstName(doctor_firstName: String): Deferred<LiveData<List<Doctor>>> = GlobalScope.async{
        return@async doctorDao.selectFirstNameDoctor(doctor_firstName)
    }

    fun getDoctorsFullName(doctor_firstName: String, doctor_secondName: String): Deferred<LiveData<List<Doctor>>> = GlobalScope.async{
        return@async doctorDao.selectFullNameDoctor(doctor_firstName, doctor_secondName)
    }

    fun insertDoctor(doctor: Doctor) = GlobalScope.async{
        doctorDao.insertDoc(doctor)
    }

    fun deleteDoctor(doctor: Doctor) = GlobalScope.async{
        doctorDao.deleteDoc(doctor)
    }

    fun updateDoctor(doctor: Doctor) = GlobalScope.async{
        doctorDao.updateDoc(doctor)
    }
}
