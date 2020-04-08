package com.example.clinic.model.dataBase.visit

import androidx.lifecycle.LiveData
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

    @Query("select * from visit where id = :id")
    fun selectIdVisits(id: Int): Visit

    @Query("select * from visit")
    fun selectAllVisits(): List<Visit>

    @Query("select * from visit where visit_date = :visit_date")
    fun selectDateVisits(visit_date: Date): List<Visit>                            // по дате

    @Query("select * from visit where visit_complaints = :visit_complaints")
    fun selectComplaintsVisits(visit_complaints: String): List<Visit>               // жалобам

    @Query("select * from visit where visit_assignment = :visit_assignment")
    fun selectAssignmentsVisits(visit_assignment: String): List<Visit>              // назначениям

    @Query("select * from visit where doctor_id = :doctor_id")
    fun selectIdDoctorVisits(doctor_id: String): List<Visit>                        // id врача

    @Query("select * from visit where patient_id = :patient_id")
    fun selectIdPatientVisits(patient_id: String): List<Visit>                      // id пациента

    @Query("select * from visit where (doctor_id = :doctor_id) and (visit_spend = false)")
    fun selectNoSpendVisitbyDoctor(doctor_id: Int): List<Visit>

    @Query("select * from visit where (doctor_id = :doctor_id) and (visit_spend = true)")
    fun selectSpendVisitbyDoctor(doctor_id: Int): List<Visit>

    @Query("select * from visit where (patient_id = :patient_id) and (visit_spend = false)")
    fun selectNoSpendVisitbyPatient(patient_id: Int): List<Visit>

    @Query("select * from visit where (patient_id = :patient_id) and (visit_spend = true)")
    fun selectSpendVisitbyPatient(patient_id: Int): List<Visit>


}