package by.example.briefcases.presentation.ui.inspector_name

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import by.example.briefcases.R
import by.example.briefcases.databinding.FragmentInspectorNameBinding
import by.example.briefcases.presentation.ui.BaseFragment
import by.example.briefcases.utils.Variables

class InspectorNameFragment : BaseFragment<FragmentInspectorNameBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.inspectorNameContinueButton.setOnClickListener {
            Variables.inspectorName = binding.inspectorNameEditText.text.toString()
            Navigation.findNavController(binding.root).navigate(R.id.action_inspectorNameFragment_to_categoryFragment)
        }
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentInspectorNameBinding.inflate(layoutInflater,container,false)
}