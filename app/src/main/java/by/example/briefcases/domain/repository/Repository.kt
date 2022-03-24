package by.example.briefcases.domain.repository

import androidx.lifecycle.LiveData
import by.example.briefcases.data.entities.AnswerQuestion
import by.example.briefcases.data.entities.Briefcase
import by.example.briefcases.data.entities.Questionnaires
import by.example.briefcases.data.entities.Questions

interface Repository {
    fun getAllBriefcases(): LiveData<List<Briefcase>>
    suspend fun addNewBriefcase(briefcase: Briefcase)
    fun getQuestionByBriefcase(briefcaseID: String): LiveData<List<AnswerQuestion>>
    suspend fun getCategories(): List<Questionnaires>
    suspend fun getQuestions(qid: Int) : List<Questions>
    suspend fun addQuestionToLocal(answerQuestion: AnswerQuestion)
}