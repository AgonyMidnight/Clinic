package com.example.clinic.model.repository

import android.content.Context
import com.example.clinic.model.dataBase.ClinicDataBase
import com.example.clinic.model.dataBase.visit.VisitDao

class MainRepository(
    context: Context,
    clinicDataBase: ClinicDataBase
) {
    private val visitDao = clinicDataBase.visitDao()
    private val patientDao = clinicDataBase.patientDao()
    private val doctorDao = clinicDataBase.doctorDao()

    


}