package com.example.clinic.model.dataBase.patient

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.clinic.model.dataBase.patient.Patient

@Dao
@TypeConverters(DateConverter::class)
interface PatientDao {
    @Insert
    fun insertDoc(patient: Patient)

    @Delete
    fun deleteDoc(patient: Patient)

    @Update
    fun updateDoc(patient: Patient)

    @Query("select * from patient")
    fun selectAllPatient(): LiveData<List<Patient>>

    @Query("select * from patient where patient_secondName = :patient_secondName")
    fun selectSecondNamePatient(patient_secondName: String): LiveData<List<Patient>>                         // по фамилии

    @Query("select * from patient where patient_firstName = :patient_firstName")
    fun selectFirstNamePatient(patient_firstName: String): LiveData<List<Patient>>                          // по имени / отчеству

    @Query("select * from patient where (patient_firstName = :patient_firstName) or (patient_secondName = :patient_secondName)")
    fun selectFullNamePatient(patient_firstName: String, patient_secondName: String): LiveData<List<Patient>>       // по ФИО

    @Query("select * from patient where id = :id")
    fun selectIdPatient(id: Int): Patient
}