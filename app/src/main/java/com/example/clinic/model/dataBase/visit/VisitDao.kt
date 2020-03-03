package com.example.clinic.model.dataBase.visit

import androidx.room.*
import com.example.clinic.model.dataBase.patient.DateConverter
import com.example.clinic.model.dataBase.patient.Patient
import java.util.*

@Dao
@TypeConverters(DateConverter::class)
interface VisitDao {
    @Insert
    suspend fun insertDoc(visit: Visit)

    @Delete
    suspend fun deleteDoc(visit: Visit)

    @Update
    suspend fun updateDoc(visit: Visit)

    @Query("select * from visit")
    suspend fun selectAllPatient(): List<Visit>

    @Query("select * from visit where visit_date = :visit_date")
    suspend fun selectDatePatient(visit_date: Date): List<Visit>                             // по дате

    @Query("select * from visit where visit_complaints = :visit_complaints")
    suspend fun selectComplaintsPatient(visit_complaints: String): List<Visit>                    // жалобам

    @Query("select * from visit where visit_assignment = :visit_assignment")
    suspend fun selectAssignmentsPatient(visit_assignment: String): List<Visit>                   // назначениям

    @Query("select * from visit where doctor_id = :doctor_id")
    suspend fun selectIdDoctorPatient(doctor_id: String): List<Visit>                        // id врача

    @Query("select * from visit where patient_id = :patient_id")
    suspend fun selectIdPatientPatient(patient_id: String): List<Visit>                      // id пациента

    @Query("select * from visit where id = :id")
    suspend fun selectIdVisits(id: Int): Visit
}