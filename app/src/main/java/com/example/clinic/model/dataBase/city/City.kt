package com.example.clinic.model.dataBase.city

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class City (
    @PrimaryKey(autoGenerate = true) var id: Int,
    var city_Name: String
)