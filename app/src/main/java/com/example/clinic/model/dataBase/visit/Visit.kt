package com.example.clinic.model.dataBase.visit

import androidx.room.*
import java.util.*

@Entity
class Visit(
        @PrimaryKey(autoGenerate = true) var id: Int,
        var visit_date: Date,               // дата посещения
        var visit_complaints: String,       // жалобы
        var visit_assignment: String?,      // назначения
        var visit_comments: String?,        // допИнф посещения
        var doctor_id: Int,
        var patient_id: Int,
        var visit_spend: Boolean
)