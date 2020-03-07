package com.example.clinic.model.dataBase.visit

import androidx.lifecycle.LiveData
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
    suspend fun selectAllVisits(): LiveData<List<Visit>>

    @Query("select * from visit where visit_date = :visit_date")
    suspend fun selectDateVisits(visit_date: Date): LiveData<List<Visit>>                             // по дате

    @Query("select * from visit where visit_complaints = :visit_complaints")
    suspend fun selectComplaintsVisits(visit_complaints: String): LiveData<List<Visit>>                       // жалобам

    @Query("select * from visit where visit_assignment = :visit_assignment")
    suspend fun selectAssignmentsVisits(visit_assignment: String): LiveData<List<Visit>>                     // назначениям

    @Query("select * from visit where doctor_id = :doctor_id")
    suspend fun selectIdDoctorVisits(doctor_id: String): LiveData<List<Visit>>                           // id врача

    @Query("select * from visit where patient_id = :patient_id")
    suspend fun selectIdPatientVisits(patient_id: String): LiveData<List<Visit>>                      // id пациента

    @Query("select * from visit where id = :id")
    suspend fun selectIdVisits(id: Int): Visit
}