package com.example.clinic.model.dataBase.doctor

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.clinic.model.dataBase.ClinicDataBase

class DoctorRepository (
    context: Context,
    clinicDataBase: ClinicDataBase
) {
    private val doctorDao = clinicDataBase.doctorDao()

    fun getDoctorID(doctor_id: Int): Doctor{
        return doctorDao.selectIdDoctor(doctor_id)
    }

    fun getDoctorsAll(): LiveData<List<Doctor>> {
        return doctorDao.selectAllDoctor()
    }

    fun getDoctorsSecondName(doctor_secondName: String): LiveData<List<Doctor>>{
        return doctorDao.selectSecondNameDoctor(doctor_secondName)
    }

    fun getDoctorFirstName(doctor_firstName: String): LiveData<List<Doctor>>{
        return doctorDao.selectFirstNameDoctor(doctor_firstName)
    }

    fun getDoctorsFullName(doctor_firstName: String, doctor_secondName: String): LiveData<List<Doctor>>{
        return doctorDao.selectFullNameDoctor(doctor_firstName, doctor_secondName)
    }

    fun insertDoctor(doctor: Doctor){
        doctorDao.insertDoc(doctor)
    }

    fun deleteDoctor(doctor: Doctor){
        doctorDao.deleteDoc(doctor)
    }

    fun updateDoctor(doctor: Doctor){
        doctorDao.updateDoc(doctor)
    }
}
