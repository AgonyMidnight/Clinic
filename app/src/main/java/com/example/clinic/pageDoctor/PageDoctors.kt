package com.example.clinic.pageDoctor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.clinic.databinding.PageDoctorsFragmentBinding
import kotlinx.android.synthetic.main.page_doctors_fragment.*
import kotlinx.android.synthetic.main.page_doctors_fragment.view.*
import kotlinx.android.synthetic.main.page_doctors_fragment.view.justtest


class PageDoctors : Fragment() {

    private lateinit var dataBinding: PageDoctorsFragmentBinding

    private val viewModel: PageDoctorsViewModel? by viewModels{
        object: ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
               PageDoctorsViewModel() as T
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = PageDoctorsFragmentBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val Last = arguments?.getString("id")
        if (Last != null) {
            viewModel!!.NameDoctor =  Last
        }
        super.onViewCreated(view, savedInstanceState)
        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = viewLifecycleOwner
    }



}