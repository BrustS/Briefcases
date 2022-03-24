package by.example.briefcases.presentation.ui.inspection_type

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import by.example.briefcases.R
import by.example.briefcases.databinding.FragmentInspectionTypeBinding
import by.example.briefcases.presentation.ui.BaseFragment
import by.example.briefcases.presentation.ui.ItemsAdapter
import by.example.briefcases.presentation.ui.onItemClickItemListener
import by.example.briefcases.utils.ConfirmAlertDialog
import by.example.briefcases.utils.Variables
import by.example.briefcases.utils.inspectionType


class InspectionTypeFragment : BaseFragment<FragmentInspectionTypeBinding>() {
    private val itemAdapter = ItemsAdapter(R.drawable.ic_baseline_playlist_add_check_24)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.inspectionTypeRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = itemAdapter
        }
        itemAdapter.setOnItemClickListener(object : onItemClickItemListener {
            override fun onItemClick(absoluteAdapterPosition: Int) {
                val alertDialog = ConfirmAlertDialog(
                    binding.root.context, "Inspection Type", inspectionType[absoluteAdapterPosition]
                ) { positiveClick()
                Variables.inspectionType = inspectionType[absoluteAdapterPosition]}.createAlertDialog()
                    .show()
            }
        })
        itemAdapter.setListData(inspectionType)
    }

    private fun positiveClick() {
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_inspectionTypeFragment_to_inspectorSourceFragment)
    }


    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )=FragmentInspectionTypeBinding.inflate(inflater,container,false)
}