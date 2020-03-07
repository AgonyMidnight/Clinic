package com.example.clinic.service

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.clinic.R
import com.example.clinic.databinding.ServiceFragmentBinding
import com.example.clinic.personal_account.PersonalAccountViewModel


class service : Fragment() {

    private lateinit var dataBinding:ServiceFragmentBinding
    private val viewModel: ServiceViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                ServiceViewModel() as T

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding =  ServiceFragmentBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dataBinding.buttonAnalisis.setOnClickListener{
           // findNavController().navigate(R.id.navigation_personal_account)
        }
        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = viewLifecycleOwner
        // TODO: Use the ViewModel
    }

}