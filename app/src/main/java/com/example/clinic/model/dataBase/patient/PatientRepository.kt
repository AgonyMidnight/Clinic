package com.example.clinic.model.dataBase.patient

import android.content.Context
import com.example.clinic.model.dataBase.ClinicDataBase
import java.util.*

class PatientRepository(context: Context) {
    private val clinicDataBase = ClinicDataBase(context)
    private val patientDao = clinicDataBase.patientDao()
    private var errorFlagPatientApi: Boolean = false

    suspend fun getPatientID(id: Int) {
        try {
            val patient = PatientNetworkService.patientApi().getPatientInfo(id)
        } catch (e: Throwable) {
            errorFlagPatientApi = true
        }
    }

    suspend fun getPatientID(patientLogin: String, patientPass: String) {
        try {
            val patient = PatientNetworkService.patientApi().getIdPatient(patientLogin, patientPass)
        } catch (e: Throwable) {
            errorFlagPatientApi = true
        }
    }

    suspend fun insertPatient(
        patient_firstName: String,
        patient_secondName: String,
        patient_addressNumber: String,
        patient_addressStreet: String,
        patient_phone: String,
        patient_birthday: Date,
        patient_login: String,
        patient_password: String,
        patient_numberMedCard: String,
        patient_medPolice: String
    ) {
        try {
            PatientNetworkService.patientApi().setNewPatient(
                patient_firstName,
                patient_secondName,
                patient_addressNumber,
                patient_addressStreet,
                patient_phone,
                patient_birthday,
                patient_login,
                patient_password,
                patient_numberMedCard,
                patient_medPolice
            )
        } catch (e: Throwable) {
            errorFlagPatientApi = true
        }
    }

    suspend fun updatePatient(
        id: Int,
        patient_firstName: String,
        patient_secondName: String,
        patient_addressNumber: String,
        patient_addressStreet: String,
        patient_phone: String,
        patient_birthday: Date,
        patient_login: String,
        patient_password: String,
        patient_numberMedCard: String,
        patient_medPolice: String
    ) {
        try {
            PatientNetworkService.patientApi().updatePatient(
                id,
                patient_firstName,
                patient_secondName,
                patient_addressNumber,
                patient_addressStreet,
                patient_phone,
                patient_birthday,
                patient_login,
                patient_password,
                patient_numberMedCard,
                patient_medPolice
            )
        } catch (e: Throwable) {
            errorFlagPatientApi = true
        }
    }
}