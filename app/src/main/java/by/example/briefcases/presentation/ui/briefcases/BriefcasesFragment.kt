package by.example.briefcases.presentation.ui.briefcases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import by.example.briefcases.R
import by.example.briefcases.data.entities.Briefcase
import by.example.briefcases.databinding.FragmentBriefcasesBinding
import by.example.briefcases.presentation.ui.BaseFragment
import by.example.briefcases.presentation.ui.onItemClickItemListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BriefcasesFragment : BaseFragment<FragmentBriefcasesBinding>() {

    private val adapterBriefcase = BriefcaseAdapter()
    private var listBriefcases = listOf<Briefcase>()
    private val viewModel: BriefcaseViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val toolbarTitle = activity?.findViewById<TextView>(R.id.toolbarTitle)
        toolbarTitle?.text = getString(R.string.briefcase)

        binding.briefcaseRecycler.apply {
            adapter = adapterBriefcase
            layoutManager = GridLayoutManager(requireContext(), 2)
        }

//        adapterBriefcase.setOnItemClickListener(object : onItemClickItemListener {
//            override fun onItemClick(absoluteAdapterPosition: Int) {
//
//                Navigation.findNavController(binding.root).navigate(directions)
//            }
//
//        })

        viewModel.briefcases.observe(viewLifecycleOwner) {
            listBriefcases = it
            adapterBriefcase.setData(it)
        }

        binding.addBriefcaseFAB.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_briefcasesFragment_to_vesselFragment)
        }
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentBriefcasesBinding.inflate(inflater, container, false)
}
