package com.example.clinic.model.dataBase.specialization

import android.content.Context
import com.example.clinic.model.dataBase.ClinicDataBase

class SpecializationRepository (context: Context){
    private val clinicDataBase = ClinicDataBase(context)
    private val specializationDao = clinicDataBase.specializationDao()

    suspend fun getSpecializationID(specialization_id: Int): Specialization = specializationDao.selectIdSpecialization(specialization_id)

    suspend fun getSpecialization(specialization_name: String): List<Specialization> = specializationDao.selectSpecializationName(specialization_name)

    suspend fun getAllSpecialization(): List<Specialization> = specializationDao.selectAllSpecialization()

    suspend fun insertSpecialization(specialization: Specialization) = specializationDao.insertSpecialization(specialization)

    suspend fun deleteSpecialization(specialization: Specialization) = specializationDao.deleteSpecialization(specialization)

    suspend fun updateSpecialization(specialization: Specialization) = specializationDao.updateSpecialization(specialization)
}