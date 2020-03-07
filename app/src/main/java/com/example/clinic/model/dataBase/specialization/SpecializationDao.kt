package com.example.clinic.model.dataBase.specialization

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.clinic.model.dataBase.patient.Patient

@Dao
interface SpecializationDao {
    @Insert
    fun insertSpecialization(specialization: Specialization)

    @Delete
    fun deleteSpecialization(specialization: Specialization)

    @Update
    fun updateSpecialization(specialization: Specialization)

    @Query("select * from specialization")
    fun selectAllSpecialization(): LiveData<List<Specialization>>

    @Query("select * from specialization where id = :id")
    fun selectIdSpecialization(id: Int): Specialization

    @Query("select * from specialization where specialization_Name = :specialization_Name")
    fun selectSpecializationName(specialization_Name: String): LiveData<List<Specialization>>
}