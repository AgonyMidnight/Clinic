package com.example.clinic.model.dataBase.specialization

import androidx.room.*

@Dao
interface SpecializationDao {
    @Insert
    fun insertSpecialization(specialization: Specialization)

    @Delete
    fun deleteSpecialization(specialization: Specialization)

    @Update
    fun updateSpecialization(specialization: Specialization)

    @Query("select * from specialization")
    fun selectAllSpecialization(): List<Specialization>

    @Query("select * from specialization where id = :id")
    fun selectIdSpecialization(id: Int): Specialization

    @Query("select * from specialization where specialization_Name = :specialization_Name")
    fun selectSpecializationName(specialization_Name: String): List<Specialization>
}