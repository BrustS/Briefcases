package by.example.briefcases.presentation.ui.answers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import by.example.briefcases.R


class AnswersFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val toolbarText = activity?.findViewById<TextView>(R.id.toolbarTitle)
        toolbarText?.text = "Answers"
        return inflater.inflate(R.layout.fragment_answers, container, false)
    }
}