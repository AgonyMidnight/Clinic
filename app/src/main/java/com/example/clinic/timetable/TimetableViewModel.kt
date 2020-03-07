package com.example.clinic.timetable

import android.widget.Spinner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimetableViewModel : ViewModel() {
    val spinnerOfTerapist: MutableLiveData<Spinner> = MutableLiveData()
    val spinnerOfSurgeon: MutableLiveData<Spinner> = MutableLiveData()
    val spinnerOfNeurologist: MutableLiveData<Spinner> = MutableLiveData()

}

