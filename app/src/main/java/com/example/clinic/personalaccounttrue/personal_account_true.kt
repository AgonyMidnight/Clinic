package com.example.clinic.personalaccounttrue

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.clinic.R
import com.example.clinic.databinding.PersonalAccountTrueFragmentBinding




class personal_account_true : Fragment() {

    private lateinit var dataBinding: PersonalAccountTrueFragmentBinding
    private val viewModel: PersonalAccountTrueViewModel by viewModels{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return PersonalAccountTrueViewModel() as T
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = PersonalAccountTrueFragmentBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProviders.of(this).get(PersonalAccountTrueViewModel::class.java)
        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = viewLifecycleOwner

        // TODO: Use the ViewModel
    }

}



