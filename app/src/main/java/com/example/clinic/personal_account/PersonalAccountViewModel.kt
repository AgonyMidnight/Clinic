package com.example.clinic.personal_account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class PersonalAccountViewModel(
        private val UserId: String,
        private val repository: PersonalRepository


) : ViewModel() {
  // private val text = ObservableField<String>()
   private var _personal:PersonalRepository.Personal? = null
       set(value) {
           field = value
           (personal as MutableLiveData).postValue(value)
       }
    val personal:LiveData<PersonalRepository.Personal> = MutableLiveData()

    private var _isLoading = true
        set(value) {
            field = value
            (isLoading as MutableLiveData).postValue(value)
        }
    val isLoading: LiveData<Boolean> = MutableLiveData(_isLoading)

    init {
        viewModelScope.launch {
            val personal: PersonalRepository.Personal? = try{
                repository.loadData(UserId)
            } catch (t: Throwable){
                print(t.message)
                null
            }

            _isLoading = false
            personal?.let {_personal = it}
        }
    }


}