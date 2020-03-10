package com.example.clinic.timetable

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.clinic.R
//import com.example.clinic.personal_account.personal_account
import com.example.clinic.databinding.TimetableFragmentBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.timetable_fragment.*

class timetable : Fragment() {

    private lateinit var dataBinding:TimetableFragmentBinding
    private val viewModel: TimetableViewModel by viewModels{
        object: ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                TimetableViewModel() as T
        }
    }

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        dataBinding = TimetableFragmentBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = viewLifecycleOwner

        dataBinding.spinerofterapist.setOnItemClickListener { _, _, position, _ ->
            viewModel.
            spinnerOfTerapist.
            value?.
            getOrNull(position)?.
            let { viewModel.SelDoctors = it }
        }

        viewModel.spinnerOfTerapist.observe(viewLifecycleOwner, Observer ( ::displayModels ))
    }
    private fun displayModels(models:List<TimetableViewModel.Doctors>?){
        spinerofterapist ?: return
        dataBinding.spinerofterapist.adapter = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.activity_list_item,
            spinerofterapist.map{ it.title}
        )

    }
}


