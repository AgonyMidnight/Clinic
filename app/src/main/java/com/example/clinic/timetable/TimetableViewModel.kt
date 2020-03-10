package com.example.clinic.timetable

import android.widget.Spinner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimetableViewModel : ViewModel() {
    private val _spinnerOfTerapist: List<Doctors> = listOf(
        Doctors("Петров В.А",1235),
        Doctors("Тимонина Д.Д", 464),
        Doctors("Кравец П.п",1111)

    )
    val _spinnerOfSurgeon: List<Doctors> = listOf(
        Doctors("Петров В.А",1235),
        Doctors("Тимонина Д.Д", 464),
        Doctors("Кравец П.п",1111)

    )
    var SelDoctors: Doctors? = null
    private val _spinnerOfNeurologist:List<Doctors> = listOf(
        Doctors("Петров В.А",1235),
        Doctors("Тимонина Д.Д", 464),
        Doctors("Кравец П.п",1111)



    )
    val spinnerOfTerapist: LiveData<List<Doctors>> = MutableLiveData(_spinnerOfTerapist)
    val spinnerOfSurgeon: LiveData<List<Doctors>> = MutableLiveData(_spinnerOfSurgeon)
    val spinnerOfNeurologist: LiveData<List<Doctors>> = MutableLiveData(_spinnerOfNeurologist)

    class Doctors(val FIO:String, val id:Int)
}

