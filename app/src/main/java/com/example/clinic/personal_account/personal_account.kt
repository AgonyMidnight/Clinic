package com.example.clinic.personal_account

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.clinic.R


class personal_account : Fragment() {
    private val viewModel: PersonalAccountViewModel by viewModel{
        object:ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
               // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                PersonalAccountViewModel("87317", personal_account_repositoruMoked()) as T

        }
    }
//    companion object {
//        fun newInstance() =
//            personal_account()
//    }

    private lateinit var dataBinding: personal_accountBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = personal_accountBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = viewLifecycleOwner
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(PersonalAccountViewModel::class.java)
//        // TODO: Use the ViewModel
//    }



}