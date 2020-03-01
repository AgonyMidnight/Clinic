package com.example.clinic.model.dataBase.doctor

import androidx.lifecycle.LiveData
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

    @Query("select * from doctor")
    fun selectAllDoctor(): LiveData<List<Doctor>>

    @Query("select * from doctor where doctor_secondName = :doctor_secondName")
    fun selectSecondNameDoctor(doctor_secondName: String): LiveData<List<Doctor>>                     // по фамилии

    @Query("select * from doctor where doctor_firstName = :doctor_firstName")
    fun selectFirstNameDoctor(doctor_firstName: String): LiveData<List<Doctor>>                          // по имени / отчеству

    @Query("select * from doctor where (doctor_firstName = :doctor_firstName) or (doctor_secondName = :doctor_secondName)")
    fun selectFullNameDoctor(doctor_firstName: String, doctor_secondName: String): LiveData<List<Doctor>>       // по ФИО

    @Query("select * from doctor where id = :id")
    fun selectIdDoctor(id: Int): Doctor
}