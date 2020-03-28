package com.example.clinic.personal_account

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
import com.example.clinic.databinding.PersonalAccountFragmentBinding


class personal_account : Fragment() {

    private lateinit var dataBinding: PersonalAccountFragmentBinding
    private val viewModel: PersonalAccountViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                PersonalAccountViewModel("87317", personal_account_repositoruMoked()) as T

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        dataBinding = PersonalAccountFragmentBinding.inflate(inflater, container, false)
        return dataBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (viewModel.Autorisation == true) {
            view.findNavController().navigate(R.id.navigation_personal_true_account)
        }
        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = viewLifecycleOwner
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(PersonalAccountViewModel::class.java)
//        // TODO: Use the ViewModel
//    }


}