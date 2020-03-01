package com.example.clinic.model.dataBase.patient

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat
import java.util.*

@Entity
class Patient(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var firstName: String,      // имя / отчество
    var secondName: String,     // фамилия
    var birthday: Date,   // ДР
    var addressNumber: String,  // адресНомерДома
    var addressStreet: String,  // адресУлица
    var addressCity: String,    // адресГород
    var phone: String,          // телефон
    var numberMedCard: String,  // номер медКарты
    var medPolice: String       // медПолис
)