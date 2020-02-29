package com.example.clinic.model.dataBase.doctor

import androidx.room.*
import com.example.clinic.model.dataBase.doctor.Doctor

@Dao
interface DoctorDao {
    @Insert
    fun insertDoc(doctor: Doctor)

    @Delete
    fun deleteDoc(doctor: Doctor)

    @Update
    fun updateDoc(doctor: Doctor)

    @Query("select * from doctors")
    fun selectAllDoctor(): List<Doctor>

    @Query("select * from doctors where secondName = :secondName")
    fun selectSecondNameDoctor(secondName : String)                        // по фамилии

    @Query("select * from doctors where firstName = :firstName")
    fun selectFirstNameDoctor(firstName : String)                          // по имени / отчеству

    @Query("select * from doctors where (firstName = :firstName) or (secondName = :secondName)")
    fun selectFullNameDoctor(firstName : String, secondName: String)       // по ФИО

    @Query("select * from doctors where id = :id")
    fun selectIdDoctor(id : Int)
}