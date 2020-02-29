package com.example.clinic.timetable

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.clinic.R
import com.example.clinic.personal_account.personal_account
import kotlinx.android.synthetic.main.activity_main.*

class timetable : Fragment() {

   // companion object {
     //   fun newInstance() = timetable()
   // }

   // private lateinit var viewModel: TimetableViewModel

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        return inflater.inflate(R.layout.timetable_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        bottom_navigation.setOnClickListener{

        }
        //viewModel = ViewModelProviders.of(this).get(TimetableViewModel::class.java)
        // TODO: Use the ViewModel
    }

}