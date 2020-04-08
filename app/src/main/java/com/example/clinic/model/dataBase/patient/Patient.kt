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
    var patient_login: String,
    var patient_pass: String,
    var patient_birthday: Date,         // ДР
    var patient_addressNumber: String,  // адресНомерДома
    var patient_addressStreet: String,  // адресУлица
    var patient_addressCity: Int,       // адресГород
    var patient_phone: String?,         // телефон
    var patient_numberMedCard: String,  // номер медКарты
    var patient_medPolice: String       // медПолис
)