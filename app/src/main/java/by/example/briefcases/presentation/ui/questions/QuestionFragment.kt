package by.example.briefcases.presentation.ui.questions

import android.content.ClipData
import android.media.MediaCodec
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.example.briefcases.R
import by.example.briefcases.databinding.FragmentQuestionsBinding
import by.example.briefcases.presentation.ui.BaseFragment
import by.example.briefcases.presentation.ui.ItemsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuestionFragment: BaseFragment<FragmentQuestionsBinding>() {

    private val viewModel : QuestionViewModel by viewModels()
    private val itemAdapter = ItemsAdapter(R.drawable.ic_baseline_question_mark_24)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerQuestions.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = itemAdapter
        }

        viewModel.questions.observe(viewLifecycleOwner) {
            itemAdapter.setListData(it.map { question -> question.question })
        }
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentQuestionsBinding.inflate(layoutInflater,container,false)
}