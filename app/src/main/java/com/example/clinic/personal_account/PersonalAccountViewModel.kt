package com.example.clinic.personal_account

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavGraphNavigator
import androidx.navigation.Navigation
import com.example.clinic.R
import kotlinx.coroutines.launch


class PersonalAccountViewModel(

    private val UserId: String,
    private val repository: PersonalRepository


) : ViewModel() {
    val Autorisation = true
//  // private val text = ObservableField<String>()
//   private var _personal:PersonalRepository.Personal? = null
//       set(value) {
//           field = value
//           (personal as MutableLiveData).postValue(value)
//       }
//    val personal:LiveData<PersonalRepository.Personal> = MutableLiveData()
//
//    private var _isLoading = true
//        set(value) {
//            field = value
//            (isLoading as MutableLiveData).postValue(value)
//        }
//    val isLoading: LiveData<Boolean> = MutableLiveData(_isLoading)

    init {
        viewModelScope.launch {
//            if (Autorisation == false) {
//                this.findNavController().navigate(R.id.navigation_personal_true_account)
////
//            }

            // personal?.let {_personal = it}
        }
    }


}