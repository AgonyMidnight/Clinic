package com.example.clinic.timetable

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.fragment.app.findFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.clinic.R
//import com.example.clinic.personal_account.personal_account
import com.example.clinic.databinding.TimetableFragmentBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.timetable_fragment.*

class timetable : Fragment() {

    private lateinit var dataBinding: TimetableFragmentBinding
    private val viewModel: TimetableViewModel by viewModels {
        object : ViewModelProvider.Factory {
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
        dataBinding.spinerofterapist.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) = Unit
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    viewModel.spinnerOfTerapist.value?.get(position)
                        ?.let {
                            if (!viewModel.chooseTerap) {
                                viewModel.chooseTerap = true
                            } else {
                                viewModel.setDataDoctor(it.id.toString(), view)
                            }
                        }
                }
            }

        dataBinding.spinneroftrautomologist.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) = Unit
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    viewModel.spinerOfTraumatologist.value?.getOrNull(position)
                        ?.let {if (!viewModel.chooseTravm) {
                            viewModel.chooseTravm = true
                        } else {
                            viewModel.setDataDoctor(it.id.toString(), view)
                        }
                        }
                }

            }


        dataBinding.spinerofsurgeon.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) = Unit
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    viewModel.spinnerOfSurgeon.value?.getOrNull(position)
                        ?.let { if (!viewModel.chooseSurg) {
                            viewModel.chooseSurg = true
                        } else {
                            viewModel.setDataDoctor(it.id.toString(), view)
                        } }
                }
            }

        dataBinding.spinerofnevrolgist.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) = Unit
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    viewModel.spinnerOfNeurologist.value?.getOrNull(position)
                        ?.let {
                            if (!viewModel.chooseNevrol) {
                                viewModel.chooseNevrol = true
                            } else {
                                viewModel.setDataDoctor(it.id.toString(), view)
                            }

                        }
                }

            }


        viewModel.spinnerOfTerapist.observe(viewLifecycleOwner, Observer(::displayModels))
        viewModel.spinnerOfSurgeon.observe(viewLifecycleOwner, Observer(::displaySurgeon))
        viewModel.spinnerOfNeurologist.observe(viewLifecycleOwner, Observer(::displayNeurologist))
        viewModel.spinerOfTraumatologist.observe(
            viewLifecycleOwner,
            Observer(::displayTrautomologist)
        )
    }

    private fun displaySurgeon(spinerofsurgeon: List<TimetableViewModel.Doctors>?) {
        spinerofsurgeon ?: return
        dataBinding.spinerofsurgeon.adapter = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_expandable_list_item_1,
            spinerofsurgeon.map { it.FIO }
        )
        spinerofsurgeon
            .indexOf(viewModel.SelDoctors)
            .takeIf { it > -1 }
            ?.let { dataBinding.spinerofsurgeon.setSelection(it) }

    }

    private fun displayTrautomologist(spinneroftrautomologist: List<TimetableViewModel.Doctors>) {
        spinneroftrautomologist ?: return
        dataBinding.spinneroftrautomologist.adapter = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_expandable_list_item_1,
            spinneroftrautomologist.map { it.FIO }

        )
        spinneroftrautomologist
            .indexOf(viewModel.SelDoctors)
            .takeIf { it > -1 }
            ?.let { dataBinding.spinneroftrautomologist.setSelection(it) }
    }


    private fun displayNeurologist(spinerofnevrolgist: List<TimetableViewModel.Doctors>?) {
        spinerofnevrolgist ?: return
        dataBinding.spinerofnevrolgist.adapter = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_expandable_list_item_1,
            spinerofnevrolgist.map { it.FIO }
        )
        spinerofnevrolgist
            .indexOf(viewModel.SelDoctors)
            .takeIf { it > -1 }
            ?.let { dataBinding.spinerofnevrolgist.setSelection(it) }

    }


    private fun displayModels(spinerofterapist: List<TimetableViewModel.Doctors>?) {
        spinerofterapist ?: return
        dataBinding.spinerofterapist.adapter = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_expandable_list_item_1,
            spinerofterapist.map { it.FIO }
        )
        spinerofterapist
            .indexOf(viewModel.SelDoctors)
            .takeIf { it > -1 }
            ?.let { dataBinding.spinerofterapist.setSelection(it) }

    }

}


