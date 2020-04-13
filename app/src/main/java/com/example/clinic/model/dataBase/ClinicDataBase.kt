package com.example.clinic.model.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.clinic.model.dataBase.city.City
import com.example.clinic.model.dataBase.city.CityDao
import com.example.clinic.model.dataBase.doctor.Doctor
import com.example.clinic.model.dataBase.doctor.DoctorDao
import com.example.clinic.model.dataBase.patient.Patient
import com.example.clinic.model.dataBase.patient.PatientDao
import com.example.clinic.model.dataBase.specialization.Specialization
import com.example.clinic.model.dataBase.specialization.SpecializationDao
import com.example.clinic.model.dataBase.visit.Visit
import com.example.clinic.model.dataBase.visit.VisitDao

@Database(
    entities = [Doctor::class, Patient::class, Visit::class, Specialization::class, City::class],
    version = 1
) abstract class ClinicDataBase : RoomDatabase(){
    abstract fun patientDao(): PatientDao
    abstract fun doctorDao(): DoctorDao
    abstract fun visitDao(): VisitDao
    abstract fun specializationDao(): SpecializationDao
    abstract fun cityDao(): CityDao

    companion object{
        @Volatile private var instance: ClinicDataBase? = null
        private val Lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(Lock){
            instance ?: buildDataBase(context).also { instance = it }
        }

        private fun buildDataBase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ClinicDataBase::class.java, "clinic_db")
                .build()
    }
}