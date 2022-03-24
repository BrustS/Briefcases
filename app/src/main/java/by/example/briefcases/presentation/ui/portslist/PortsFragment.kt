package by.example.testApp.presentation.ui.portslist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import by.example.briefcases.R
import by.example.briefcases.databinding.FragmentPortsBinding
import by.example.briefcases.presentation.ui.BaseFragment
import by.example.briefcases.presentation.ui.ItemsAdapter
import by.example.briefcases.presentation.ui.onItemClickItemListener
import by.example.briefcases.utils.ConfirmAlertDialog
import by.example.briefcases.utils.Variables
import by.example.briefcases.utils.ports


class PortsFragment : BaseFragment<FragmentPortsBinding>() {
    private val itemAdapter = ItemsAdapter(R.drawable.ic_baseline_anchor_24)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.portsRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = itemAdapter
        }
        itemAdapter.setOnItemClickListener(object : onItemClickItemListener {
            override fun onItemClick(absoluteAdapterPosition: Int) {
                ConfirmAlertDialog(
                    requireContext(), "Ports", ports[absoluteAdapterPosition]
                ) { positiveClick()
                    Variables.port = ports[absoluteAdapterPosition]
                }.createAlertDialog()
                    .show()
            }
        })
        itemAdapter.setListData(ports)

        binding.searchPortEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0 != null) {
                    val searchList = ports.filter { it.contains(p0) }
                    itemAdapter.setListData(searchList)
                }
            }
            override fun afterTextChanged(p0: Editable?) { }
        })
    }

    private fun positiveClick() {
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_portsFragment_to_inspectionTypeFragment)
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentPortsBinding.inflate(inflater, container, false)
}