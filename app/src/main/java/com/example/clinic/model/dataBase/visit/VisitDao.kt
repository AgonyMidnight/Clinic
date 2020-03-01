package com.example.clinic.model.dataBase.visit

import androidx.room.*
import com.example.clinic.model.dataBase.patient.Patient
import java.util.*

@Dao
interface VisitDao {
    @Insert
    fun insertDoc(visit: Visit)

    @Delete
    fun deleteDoc(visit: Visit)

    @Update
    fun updateDoc(visit: Visit)

    @Query("select * from visit")
    fun selectAllPatient(): List<Visit>

    @Query("select * from visit where dateVisit = :dateVisit")
    fun selectDatePatient(dateVisit : Date)                             // по дате

    @Query("select * from visit where complaints = :complaints")
    fun selectComplaintsPatient(complaints : String)                    // жалобам

    @Query("select * from visit where assignment = :assignment")
    fun selectAssignmentsPatient(assignment : String)                   // назначениям

    @Query("select * from visit where doctor_id = :idDoctor")
    fun selectIdDoctorPatient(idDoctor : String)                        // id врача

    @Query("select * from visit where patient_id = :idPatient")
    fun selectIdPatientPatient(idPatient : String)                      // id пациента

    @Query("select * from visit where id = :id")
    fun selectIdVisits(id : Int)
}