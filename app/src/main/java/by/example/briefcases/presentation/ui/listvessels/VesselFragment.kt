package by.example.briefcases.presentation.ui.listvessels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import by.example.briefcases.R
import by.example.briefcases.databinding.VesselFragmentBinding
import by.example.briefcases.presentation.ui.BaseFragment
import by.example.briefcases.presentation.ui.ItemsAdapter
import by.example.briefcases.presentation.ui.onItemClickItemListener
import by.example.briefcases.utils.ConfirmAlertDialog
import by.example.briefcases.utils.Variables
import by.example.briefcases.utils.vessels

class VesselFragment : BaseFragment<VesselFragmentBinding>() {
    private val itemAdapter = ItemsAdapter(R.drawable.ic_baseline_directions_boat_24)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.vesselRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = itemAdapter
        }
        itemAdapter.setOnItemClickListener(object : onItemClickItemListener {
            override fun onItemClick(absoluteAdapterPosition: Int) {
                 ConfirmAlertDialog(
                    requireContext(), "Vessels", vessels[absoluteAdapterPosition]
                ) { positiveClick()
                    Variables.vessel = vessels[absoluteAdapterPosition]
                 }.createAlertDialog().show()
            }
        })
        itemAdapter.setListData(vessels)
    }

    private fun positiveClick() {
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_vesselFragment_to_portsFragment)
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = VesselFragmentBinding.inflate(inflater, container, false)
}