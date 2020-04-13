package com.example.clinic.model.dataBase.doctor

import android.content.Context
import com.example.clinic.model.dataBase.ClinicDataBase
import java.util.*

class DoctorRepository(context: Context) {
    private val clinicDataBase = ClinicDataBase(context)
    private val doctorDao = clinicDataBase.doctorDao()
    private var errorFlagDoctorApi: Boolean = false

<<<<<<< HEAD
    suspend fun getDoctorID(doctor_id: Int) {
        try {
            val doctor = DoctorNetworkService.doctorApi().getDoctorInfo(doctor_id)
        } catch (e: Throwable) {
            errorFlagDoctorApi = true
        }
=======
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
>>>>>>> 1bd403bee60ab6f8b943fbdd070c5bb4d4dc50b5
    }

    suspend fun getDoctorsAll() {
        try {
            val doctors = DoctorNetworkService.doctorApi().getAllDoctor()
        } catch (e: Throwable) {
            errorFlagDoctorApi = true
        }
    }

    suspend fun getDoctorId(doctor_login: String, doctor_pass: String) {
        try {
            val doctor = DoctorNetworkService.doctorApi().getIdDoctor(doctor_login, doctor_pass)
        } catch (e: Throwable) {
            errorFlagDoctorApi = true
        }
    }

    suspend fun getDoctorBySpecializationId(id: Int) {
        try {
            val doctors = DoctorNetworkService.doctorApi().getDoctorBySpec(id)
        } catch (e: Throwable) {
            errorFlagDoctorApi = true
        }
    }

    suspend fun setNewDoctor(
        doctor_firstName: String,
        doctor_secondName: String,
        doctor_passport: String,
        doctor_TIN: String,
        doctor_phone: String,
        doctor_birthday: Date,
        doctor_login: String,
        doctor_password: String
    ) {
        try {
            DoctorNetworkService.doctorApi().setNewDoctor(
                doctor_firstName,
                doctor_secondName,
                doctor_passport,
                doctor_TIN,
                doctor_phone,
                doctor_birthday,
                doctor_login,
                doctor_password
            )
        }catch (e: Throwable){
            errorFlagDoctorApi = true
        }
    }

    suspend fun setUpdateDoctor(
        id: Int,
        doctor_firstName: String,
        doctor_secondName: String,
        doctor_passport: String,
        doctor_TIN: String,
        doctor_phone: String,
        doctor_birthday: Date,
        doctor_login: String,
        doctor_password: String
    ) {
        try {
            DoctorNetworkService.doctorApi().updateDoctor(
                id,
                doctor_firstName,
                doctor_secondName,
                doctor_passport,
                doctor_TIN,
                doctor_phone,
                doctor_birthday,
                doctor_login,
                doctor_password
            )
        }catch (e: Throwable){
            errorFlagDoctorApi = true
        }
    }
}
