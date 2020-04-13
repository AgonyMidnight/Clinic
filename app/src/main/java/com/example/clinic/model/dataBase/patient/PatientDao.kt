package com.example.clinic.model.dataBase.patient

import androidx.room.*

@Dao
interface PatientDao {
    @Insert
    fun insertDoc(patient: Patient)

    @Delete
    fun deleteDoc(patient: Patient)

    @Update
    fun updateDoc(patient: Patient)

    @Query("select * from patient where id = :id")
    fun selectIdPatient(id: Int): Patient

    @Query("select * from patient")
    fun selectAllPatient(): List<Patient>

    @Query("select * from patient where (patient_login = :patient_login) and (patient_pass = :patient_pass)")
    fun selectPatientByLoginAndPass(patient_login: String, patient_pass: String): Patient

    @Query("select * from patient where patient_secondName = :patient_secondName")
    fun selectSecondNamePatient(patient_secondName: String): List<Patient>                         // по фамилии

    @Query("select * from patient where patient_firstName = :patient_firstName")
    fun selectFirstNamePatient(patient_firstName: String): List<Patient>                          // по имени / отчеству

    @Query("select * from patient where (patient_firstName = :patient_firstName) or (patient_secondName = :patient_secondName)")
    fun selectFullNamePatient(patient_firstName: String, patient_secondName: String): List<Patient>       // по ФИО
}