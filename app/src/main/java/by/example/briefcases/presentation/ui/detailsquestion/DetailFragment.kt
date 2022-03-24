package by.example.briefcases.presentation.ui.detailsquestion

import android.view.LayoutInflater
import android.view.ViewGroup
import by.example.briefcases.databinding.FragmenDetailQuestionBinding
import by.example.briefcases.presentation.ui.BaseFragment

class DetailFragment: BaseFragment<FragmenDetailQuestionBinding>() {
    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
   ) = FragmenDetailQuestionBinding.inflate(layoutInflater,container,false)
}