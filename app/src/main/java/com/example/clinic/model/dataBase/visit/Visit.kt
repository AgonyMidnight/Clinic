package com.example.clinic.model.dataBase.visit

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.clinic.model.dataBase.doctor.Doctor
import com.example.clinic.model.dataBase.patient.Patient
import java.util.*

@Entity
class Visit(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var dateVisit: Date,                    // дата посещения
    var complaints: String,                 // жалобы
    var assignment: String,                 // назначения
    var additionallyInfoVisit: String,      // допИнф посещения
    var idDoctor: Int,  // врач
    var idPatient: Int  // пациент
)