package com.example.clinic.timetable

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clinic.R

class timetable : Fragment() {

    companion object {
        fun newInstance() = timetable()
    }

    private lateinit var viewModel: TimetableViewModel

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {



        return inflater.inflate(R.layout.timetable_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(TimetableViewModel::class.java)
        // TODO: Use the ViewModel
    }

}