package com.example.clinic.personalaccounttrue

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clinic.R

class personal_account_true : Fragment() {

    companion object {
        fun newInstance() =
            personal_account_true()
    }

    private lateinit var viewModel: PersonalAccountTrueViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.personal_account_true_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PersonalAccountTrueViewModel::class.java)
        // TODO: Use the ViewModel
    }

}