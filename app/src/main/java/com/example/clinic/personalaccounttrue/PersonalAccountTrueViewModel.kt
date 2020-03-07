package com.example.clinic.personalaccounttrue

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PersonalAccountTrueViewModel : ViewModel() {
   val login: MutableLiveData<String> = MutableLiveData<String>()
   val password: MutableLiveData<String> = MutableLiveData<String>()

    fun ClickButtom(){

    }
    init {
        viewModelScope.launch {

        }
    }

}