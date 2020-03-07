package com.example.clinic.model.dataBase.specialization

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Specialization (
    @PrimaryKey(autoGenerate = true) var id: Int,
    var specialization_Name: String
)