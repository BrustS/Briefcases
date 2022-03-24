package by.example.briefcases.presentation.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import by.example.briefcases.R
import by.example.briefcases.data.entities.Briefcase
import by.example.briefcases.data.entities.Questionnaires
import by.example.briefcases.data.entities.Questions
import by.example.briefcases.databinding.FragmentCategoryBinding
import by.example.briefcases.presentation.ui.BaseFragment
import by.example.briefcases.presentation.ui.ItemsAdapter
import by.example.briefcases.presentation.ui.onItemClickItemListener
import by.example.briefcases.utils.ConfirmAlertDialog
import by.example.briefcases.utils.Variables
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : BaseFragment<FragmentCategoryBinding>() {

    private val viewModel: CategoryViewModel by viewModels()
    private lateinit var listQuestions:List<Questions>
    private val itemsAdapter = ItemsAdapter(imageResource = R.drawable.ic_baseline_layers_24)
    private var listCategories = emptyList<Questionnaires>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.categoryRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = itemsAdapter
        }

        itemsAdapter.setOnItemClickListener(object : onItemClickItemListener {
            override fun onItemClick(absoluteAdapterPosition: Int) {
                ConfirmAlertDialog(
                    binding.root.context,
                    "Categories",
                    listCategories[absoluteAdapterPosition].title
                ) { positiveClick(absoluteAdapterPosition) }.createAlertDialog()
                    .show()
            }
        })

        viewModel.getCategories()

        viewModel.items.observe(viewLifecycleOwner) {
            listCategories = it
            val newList = it.map { questionnaires -> questionnaires.title }
            itemsAdapter.setListData(newList)
        }
    }

    private fun positiveClick(id: Int) {
        showProgressBar { }
        viewModel.getQuestions(listCategories[id].id)

        val newBriefcase =
            Briefcase(
                vessel = Variables.vessel,
                port = Variables.port,
                inspectionType = Variables.inspectionType,
                inspectionSource = Variables.inspectorSource,
                inspectorName = Variables.inspectorName,
                category = listCategories[id].title
            )
        viewModel.questions.observe(viewLifecycleOwner) {
            it.map { question ->
                viewModel.addQuestionToLocalStorage(question,newBriefcase.dateOfCreation)
            }
        }
        viewModel.addNewBriefcaseToLocalStorage(newBriefcase)
        hideProgressBar()
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_categoryFragment_to_briefcasesFragment)
    }

    fun showProgressBar(action:()->Unit) {
        val progress = activity?.findViewById<ProgressBar>(R.id.progressBar)
       progress?.visibility = View.VISIBLE
    }

   fun hideProgressBar() {
        val progress = activity?.findViewById<ProgressBar>(R.id.progressBar)
        progress?.visibility = View.INVISIBLE
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCategoryBinding.inflate(layoutInflater, container, false)

}