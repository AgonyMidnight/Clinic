package com.example.clinic.model.dataBase.doctor

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class Doctor(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var firstName: String,  // имя / отчество
    var secondName: String, // фамилия
    var passport: String,   // серия номер
    var TIN: String,        // ИНН
    var phone: String,      // телефон
    var birthday: Date      // день рождения
)