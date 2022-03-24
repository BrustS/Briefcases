package by.example.briefcases.presentation.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.example.briefcases.data.entities.AnswerQuestion
import by.example.briefcases.data.entities.Briefcase
import by.example.briefcases.data.entities.Questionnaires
import by.example.briefcases.data.entities.Questions
import by.example.briefcases.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    private var _items = MutableLiveData<List<Questionnaires>>()
    val items: LiveData<List<Questionnaires>> get()=_items

    private var _quiestions = MutableLiveData<List<Questions>>()
    val questions: LiveData<List<Questions>> get()=_quiestions


    fun getCategories() {
      viewModelScope.launch {
        _items.value = repository.getCategories()
      }
    }

     fun getQuestions(qid: Int) {
         viewModelScope.launch {
             _quiestions.value = repository.getQuestions(qid)
         }
     }

    fun addNewBriefcaseToLocalStorage(briefcase: Briefcase) = viewModelScope.launch {
        repository.addNewBriefcase(briefcase)
    }

    fun addQuestionToLocalStorage(question: Questions, briefcaseID: String) = viewModelScope.launch(Dispatchers.IO) {
        val newAnswerQuestion = AnswerQuestion(
            questionID = question.questionID,
            questionCode = question.questionCode,
            question = question.question,
            categoryID = question.categoryID,
            origin = question.origin,
            categoryNewID = question.categoryNewID,
            briefcaseId = briefcaseID
        )
        repository.addAnswerToLocal(newAnswerQuestion)
    }

}