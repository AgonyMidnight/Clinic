package com.example.clinic.model.dataBase.doctor

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.clinic.model.dataBase.ClinicDataBase
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DoctorRepository (context: Context) {
    private val clinicDataBase = ClinicDataBase(context)
    private val doctorDao = clinicDataBase.doctorDao()

    suspend fun getDoctorID1(doctor_id: Int): Doctor = doctorDao.selectIdDoctor(doctor_id)

    suspend fun getDoctorID(doctor_id: Int){
        DoctorNetworkService.Companion
            .getJSONDoctor()
            ?.getDoctorBySpec()
            ?.enqueue(Callback<Doctor
                @Override
                fun onResponse(call: Call<Doctor>,  response: Response<Doctor>) {

                }
            });
    }

    suspend fun getDoctorsAll(): List<Doctor> = doctorDao.selectAllDoctor()

    suspend fun getDoctorsSecondName(doctor_secondName: String): List<Doctor> = doctorDao.selectSecondNameDoctor(doctor_secondName)

    suspend fun getDoctorFirstName(doctor_firstName: String): List<Doctor> = doctorDao.selectFirstNameDoctor(doctor_firstName)

    suspend fun getByLoginAndPass(doctor_login: String, doctor_pass: String): Doctor = doctorDao.selectDocByLoginAndPass(doctor_login, doctor_pass)

    suspend fun getDoctorsFullName(doctor_firstName: String, doctor_secondName: String): List<Doctor> = doctorDao.selectFullNameDoctor(doctor_firstName, doctor_secondName)

    suspend fun insertDoctor(doctor: Doctor) = doctorDao.insertDoc(doctor)

    suspend fun deleteDoctor(doctor: Doctor) = doctorDao.deleteDoc(doctor)

    suspend fun updateDoctor(doctor: Doctor) = doctorDao.updateDoc(doctor)
}
