package com.example.clinic.timetable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.clinic.databinding.TimetableFragmentBinding
import com.example.clinic.pageDoctor.PageDoctorsDirections

class TimeTableFragment : Fragment() {

    private lateinit var dataBinding: TimetableFragmentBinding

    @Suppress("UNCHECKED_CAST")
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
        dataBinding.fragment = this
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
                    _terapists.getOrNull(position)?.let(viewModel.selectedTherapist::postValue)
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
                    viewModel.traumatologists.value?.getOrNull(position)
                        ?.let {
                            if (!viewModel.chooseTravm) {
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
                    viewModel.surgeons.value?.getOrNull(position)
                        ?.let {
                            if (!viewModel.chooseSurg) {
                                viewModel.chooseSurg = true
                            } else {
                                viewModel.setDataDoctor(it.id.toString(), view)
                            }
                        }
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
                    viewModel.neurologists.value?.getOrNull(position)
                        ?.let {
                            if (!viewModel.chooseNevrol) {
                                viewModel.chooseNevrol = true
                            } else {
                                viewModel.setDataDoctor(it.id.toString(), view)
                            }

                        }
                }

            }


        viewModel.therapists.observe(viewLifecycleOwner, Observer(::displayModels))
        viewModel.surgeons.observe(viewLifecycleOwner, Observer(::displaySurgeon))
        viewModel.neurologists.observe(viewLifecycleOwner, Observer(::displayNeurologist))
        viewModel.traumatologists.observe(
            viewLifecycleOwner,
            Observer(::displayTrautomologist)
        )
    }

    private fun onDoctorSelected(doctor: TimetableViewModel.Doctor) =
        viewModel.selectDoctor(doctor) { doctorId ->
            findNavController()
                .navigate(PageDoctorsDirections.actionGlobalPageDoctors(doctorId = doctorId))

        }


    private fun displaySurgeon(spinerofsurgeon: List<TimetableViewModel.Doctor>?) {
        spinerofsurgeon ?: return
        dataBinding.spinerofsurgeon.adapter = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_expandable_list_item_1,
            spinerofsurgeon.map { it.FIO }
        )

        viewModel
            .selectedTherapist
            .value
            ?.let { viewModel.therapists.value?.indexOf(it)}
            ?. takeIf { it >= 0 }?.let { dataBinding.spinerofterapist.setSelection(it) }
    }

    private fun displayTrautomologist(spinneroftrautomologist: List<TimetableViewModel.Doctor>) {
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


    private fun displayNeurologist(spinerofnevrolgist: List<TimetableViewModel.Doctor>?) {
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


    fun displayTherapist() {
        viewModel.selectedTherapist.value?.let(::displayDoctor)
    }

    private fun displayDoctor(doctor: TimetableViewModel.Doctor) =
        findNavController().navigate(PageDoctorsDirections.actionGlobalPageDoctors(doctor.id))

    private var _terapists: List<TimetableViewModel.Doctor> = emptyList()
    private fun displayModels(spinerofterapist: List<TimetableViewModel.Doctor>?) {
        spinerofterapist ?: return

        _terapists = spinerofterapist
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


