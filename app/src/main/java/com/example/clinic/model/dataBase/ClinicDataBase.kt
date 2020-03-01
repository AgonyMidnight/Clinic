package com.example.clinic.model.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.clinic.model.dataBase.doctor.Doctor
import com.example.clinic.model.dataBase.doctor.DoctorDao
import com.example.clinic.model.dataBase.patient.Patient
import com.example.clinic.model.dataBase.patient.PatientDao
import com.example.clinic.model.dataBase.visit.Visit
import com.example.clinic.model.dataBase.visit.VisitDao


@Database(
    entities = [Doctor::class, Patient::class, Visit::class],
    version = 1
)
abstract class ClinicDataBase : RoomDatabase(){
    abstract fun patientDao(): PatientDao
    abstract fun doctorDao(): DoctorDao
    abstract fun visitDao(): VisitDao

    companion object{
        fun getDatabase(context: Context): ClinicDataBase? {
            var instance: ClinicDataBase? = null
            if (instance == null) {
                instance = Room.databaseBuilder<ClinicDataBase>(context.applicationContext,
                    ClinicDataBase::class.java, "clinic_db")
                    .build()
            }
            return instance
        }
    }
}