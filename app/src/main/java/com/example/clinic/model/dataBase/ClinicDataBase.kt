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

@Database(entities = [Doctor::class, Patient::class, Visit::class], version = 1)
abstract class ClinicDataBase : RoomDatabase(){
    abstract fun patientDao(): PatientDao
    abstract fun doctorDao(): DoctorDao

    companion object{
        private var INSTANCE: ClinicDataBase? = null
        fun getDatabase(context: Context): ClinicDataBase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder<ClinicDataBase>(context, ClinicDataBase::class.java, "clinic_db")
                    //.addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                    .build()
            }
            return INSTANCE
        }
        fun destroyInstance() { INSTANCE = null }
    }
}