package com.example.clinic.model.dataBase.visit

import androidx.room.*
import com.example.clinic.model.dataBase.patient.DateConverter
import com.example.clinic.model.dataBase.patient.Patient
import java.util.*

@Dao
@TypeConverters(DateConverter::class)
interface VisitDao {
    @Insert
    fun insertDoc(visit: Visit)

    @Delete
    fun deleteDoc(visit: Visit)

    @Update
    fun updateDoc(visit: Visit)

    @Query("select * from visit")
    fun selectAllPatient(): List<Visit>

    @Query("select * from visit where visit_date = :visit_date")
    fun selectDatePatient(visit_date: Date): List<Visit>                             // по дате

    @Query("select * from visit where visit_complaints = :visit_complaints")
    fun selectComplaintsPatient(visit_complaints: String): List<Visit>                    // жалобам

    @Query("select * from visit where visit_assignment = :visit_assignment")
    fun selectAssignmentsPatient(visit_assignment: String): List<Visit>                   // назначениям

    @Query("select * from visit where doctor_id = :doctor_id")
    fun selectIdDoctorPatient(doctor_id: String): List<Visit>                        // id врача

    @Query("select * from visit where patient_id = :patient_id")
    fun selectIdPatientPatient(patient_id: String): List<Visit>                      // id пациента

    @Query("select * from visit where id = :id")
    fun selectIdVisits(id: Int): Visit
}