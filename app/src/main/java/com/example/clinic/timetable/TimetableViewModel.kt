package com.example.clinic.timetable

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimetableViewModel : ViewModel() {
    val _therapists: List<Doctor> = listOf(
        Doctor("Не выбрано", 0),
        Doctor("Петров В.А", 1235),
        Doctor("Тимонина Д.Д", 464),
        Doctor("Кравец П.п", 1111)
    )
    val therapists: LiveData<List<Doctor>> = MutableLiveData(_therapists)
    val selectedTherapist = MutableLiveData<Doctor>()

    val _spinnerOfSurgeon: List<Doctor> = listOf(
        Doctor("Не выбрано", 0),
        Doctor("Петров В.А", 1235),
        Doctor("Тимонина Д.Д", 464),
        Doctor("Кравец П.п", 1111)

    )
    val _spinnerOfNeurologist: List<Doctor> = listOf(
        Doctor("Не выбрано", 0),
        Doctor("Петров В.А", 1235),
        Doctor("Тимонина Д.Д", 464),
        Doctor("Кравец П.п", 1111)

    )
    val _spinerOfTraumatologist: List<Doctor> = listOf(
        Doctor("Не выбрано", 0),
        Doctor("Петров В.А", 1235),
        Doctor("Тимонина Д.Д", 464),
        Doctor("Кравец П.п", 1111)

    )

    val surgeons: LiveData<List<Doctor>> = MutableLiveData(_spinnerOfSurgeon)
    val neurologists: LiveData<List<Doctor>> = MutableLiveData(_spinnerOfNeurologist)
    val traumatologists: LiveData<List<Doctor>> = MutableLiveData(_spinerOfTraumatologist)

    class Doctor(val FIO: String, val id: Int)

    fun findDoc(Name: String, foundedCallback: (List<Doctor>) -> Unit) =
        foundedCallback(_therapists.filter { it.FIO == Name })

    fun selectDoctor(doctor: Doctor, navCallback: (Int) -> Unit) = navCallback(doctor.id)

}

