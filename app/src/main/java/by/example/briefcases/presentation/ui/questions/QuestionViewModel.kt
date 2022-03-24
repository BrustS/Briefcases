package by.example.briefcases.presentation.ui.questions

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import by.example.briefcases.data.entities.AnswerQuestion
import by.example.briefcases.data.entities.Briefcase
import by.example.briefcases.domain.repository.Repository
import by.example.briefcases.utils.Variables
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    val questions: LiveData<List<AnswerQuestion>>
    init {
        questions = repository.getQuestionByBriefcase(Variables.briefcaseId)
    }
}