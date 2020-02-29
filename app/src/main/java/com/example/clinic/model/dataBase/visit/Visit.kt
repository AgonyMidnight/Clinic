package com.example.clinic.model.dataBase.visit

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.clinic.model.dataBase.doctor.Doctor
import com.example.clinic.model.dataBase.patient.Patient
import java.util.*

@Entity(foreignKeys = [(ForeignKey(entity = Doctor::class,  parentColumns = ["id"], childColumns = ["doctor_id"],  onDelete = ForeignKey.CASCADE)),
                       (ForeignKey(entity = Patient::class, parentColumns = ["id"], childColumns = ["patient_id"], onDelete = ForeignKey.CASCADE))]
, tableName = "Visits")
class Visit(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var dateVisit: Date,                    // дата посещения
    var complaints: String,                 // жалобы
    var assignment: String,                 // назначения
    var additionallyInfoVisit: String,      // допИнф посещения
    @ColumnInfo(name = "doctor_id")     var idDoctor: Int,  // врач
    @ColumnInfo(name = "patient_id")    var idPatient: Int  // пациент
)