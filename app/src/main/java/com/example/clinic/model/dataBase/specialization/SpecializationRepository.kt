package com.example.clinic.model.dataBase.specialization

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.clinic.model.dataBase.ClinicDataBase
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class SpecializationRepository (context: Context){
    private val clinicDataBase = ClinicDataBase(context)
    private val specializationDao = clinicDataBase.specializationDao()

    fun getSpecializationID(specialization_id: Int): Deferred<Specialization> = GlobalScope.async {
        return@async specializationDao.selectIdSpecialization(specialization_id)
    }

    fun getSpecialization(specialization_name: String): Deferred<LiveData<List<Specialization>>> = GlobalScope.async {
        return@async specializationDao.selectSpecializationName(specialization_name)
    }

    fun getAllSpecialization(): Deferred<LiveData<List<Specialization>>> = GlobalScope.async {
        return@async specializationDao.selectAllSpecialization()
    }

    fun insertSpecialization(specialization: Specialization) = GlobalScope.async{
        specializationDao.insertSpecialization(specialization)
    }

    fun deleteSpecialization(specialization: Specialization) = GlobalScope.async{
        specializationDao.deleteSpecialization(specialization)
    }

    fun updateSpecialization(specialization: Specialization) = GlobalScope.async{
        specializationDao.updateSpecialization(specialization)
    }


}