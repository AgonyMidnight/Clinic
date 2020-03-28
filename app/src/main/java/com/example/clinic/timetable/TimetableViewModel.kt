package com.example.clinic.timetable

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.clinic.R
import com.example.clinic.pageDoctor.PageDoctors

class TimetableViewModel : ViewModel() {
    var chooseTerap = false
    var chooseSurg = false
    var chooseNevrol = false
    var chooseTravm = false
    var chooseDoc = 0
    val _spinnerOfTerapist: List<Doctors> = listOf(
        Doctors("Не выбрано", 0),
        Doctors("Петров В.А", 1235),
        Doctors("Тимонина Д.Д", 464),
        Doctors("Кравец П.п", 1111)

    )
    val _spinnerOfSurgeon: List<Doctors> = listOf(
        Doctors("Не выбрано", 0),
        Doctors("Петров В.А", 1235),
        Doctors("Тимонина Д.Д", 464),
        Doctors("Кравец П.п", 1111)

    )
    var SelDoctors: Doctors? = null
    val _spinnerOfNeurologist: List<Doctors> = listOf(
        Doctors("Не выбрано", 0),
        Doctors("Петров В.А", 1235),
        Doctors("Тимонина Д.Д", 464),
        Doctors("Кравец П.п", 1111)

    )
    val _spinerOfTraumatologist: List<Doctors> = listOf(
        Doctors("Не выбрано", 0),
        Doctors("Петров В.А", 1235),
        Doctors("Тимонина Д.Д", 464),
        Doctors("Кравец П.п", 1111)

    )
    val spinnerOfTerapist: LiveData<List<Doctors>> = MutableLiveData(_spinnerOfTerapist)
    val spinnerOfSurgeon: LiveData<List<Doctors>> = MutableLiveData(_spinnerOfSurgeon)
    val spinnerOfNeurologist: LiveData<List<Doctors>> = MutableLiveData(_spinnerOfNeurologist)
    val spinerOfTraumatologist: LiveData<List<Doctors>> = MutableLiveData(_spinerOfTraumatologist)

    class Doctors(val FIO: String, val id: Int)

    fun findDoc(Name: String, view: View?) {
        //сделаю пока для одного терапевта. Тут будет подтяжка всех доктиоров и поиск по ним
        _spinnerOfTerapist.forEach {
            if (Name == it.FIO) {
                setDataDoctor(Name, view)
            }
        }

    }

    fun setDataDoctor(Id: String, view: View?) {
        val fragment = PageDoctors()
        val arg = Bundle()
        arg.putString("id", Id)
        fragment.arguments = arg
        view?.findNavController()?.navigate(R.id.pageDoctors)
    }

}

