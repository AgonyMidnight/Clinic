package com.example.clinic.model.dataBase.doctor

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class Doctor(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var doctor_firstName: String,  // имя / отчество
    var doctor_secondName: String, // фамилия
    var doctor_passport: String,   // серия номер
    var doctor_TIN: String,        // ИНН
    var doctor_phone: String,      // телефон
    var doctor_birthday: Date      // день рождения
)