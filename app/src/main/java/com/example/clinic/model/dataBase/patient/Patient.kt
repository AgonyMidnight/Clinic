package com.example.clinic.model.dataBase.patient

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.text.DateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Entity
class Patient(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var patient_firstName: String,      // имя / отчество
    var patient_secondName: String,     // фамилия
    @TypeConverters(DateConverter::class)
    var patient_birthday: Date,         // ДР
    var patient_addressNumber: String,  // адресНомерДома
    var patient_addressStreet: String,  // адресУлица
    var patient_addressCity: Int,       // адресГород
    var patient_phone: String?,         // телефон
    var patient_numberMedCard: String,  // номер медКарты
    var patient_medPolice: String       // медПолис
)

class DateConverter {
    @TypeConverter  // Указать, что метод является конвертером
    fun toDate(timestamp: Long?) = timestamp?.let { Date(it) }

    /*fun toDateFormat(oldDate: Date): Date{
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        var formattedDate = oldDate.format(formatter)
    }*/
}