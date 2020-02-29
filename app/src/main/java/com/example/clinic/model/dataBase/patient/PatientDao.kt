package com.example.clinic.model.dataBase.patient

import androidx.room.*
import com.example.clinic.model.dataBase.patient.Patient

@Dao
interface PatientDao {
    @Insert
    fun insertDoc(patient: Patient)

    @Delete
    fun deleteDoc(patient: Patient)

    @Update
    fun updateDoc(patient: Patient)

    @Query("select * from patients")
    fun selectAllPatient(): List<Patient>

    @Query("select * from patients where secondName = :secondName")
    fun selectSecondNamePatient(secondName : String)                         // по фамилии

    @Query("select * from patients where firstName = :firstName")
    fun selectFirstNamePatient(firstName : String)                          // по имени / отчеству

    @Query("select * from patients where (firstName = :firstName) or (secondName = :secondName)")
    fun selectFullNamePatient(firstName : String, secondName: String)       // по ФИО

    @Query("select * from patients where id = :id")
    fun selectIdPatient(id : Int)
}