package com.example.clinic.model.dataBase.visit

import androidx.room.*
import com.example.clinic.model.dataBase.doctor.Doctor
import com.example.clinic.model.dataBase.patient.Patient
import java.util.*

@Entity
class Visit(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var visit_date: Date,                    // дата посещения
    var visit_complaints: String,                 // жалобы
    var visit_assignment: String?,                 // назначения
    var visit_comments: String?,      // допИнф посещения
    var doctor_id: Int,
    var patient_id: Int
)

class DateConverter {
    @TypeConverter  // Указать, что метод является конвертером
    fun toDate(timestamp: Long?) = timestamp?.let { Date(it) }

    /*fun toDateFormat(oldDate: Date): Date{
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        var formattedDate = oldDate.format(formatter)
    }*/

    @TypeConverter  // Указать, что метод является конвертером
    fun toTimestamp(date: Date?) = date?.time
}