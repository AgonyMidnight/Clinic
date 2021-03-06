package com.example.clinic.model.dataBase.doctor

import androidx.room.*

@Dao
interface DoctorDao {
    @Insert
    fun insertDoc(doctor: Doctor)

    @Delete
    fun deleteDoc(doctor: Doctor)

    @Update
    fun updateDoc(doctor: Doctor)

    @Query("select * from doctor where id = :id")
    fun selectIdDoctor(id: Int): Doctor

    @Query("select * from doctor")
    fun selectAllDoctor(): List<Doctor>

    @Query("select * from doctor where doctor_secondName = :doctor_secondName")
    fun selectSecondNameDoctor(doctor_secondName: String): List<Doctor>                     // по фамилии

    @Query("select * from doctor where doctor_firstName = :doctor_firstName")
    fun selectFirstNameDoctor(doctor_firstName: String): List<Doctor>                          // по имени / отчеству

    @Query("select * from doctor where (doctor_login = :doctor_login) and (doctor_pass = :doctor_pass)")
    fun selectDocByLoginAndPass(doctor_login: String, doctor_pass: String): Doctor

    @Query("select * from doctor where (doctor_firstName = :doctor_firstName) or (doctor_secondName = :doctor_secondName)")
    fun selectFullNameDoctor(doctor_firstName: String, doctor_secondName: String): List<Doctor>       // по ФИО

}