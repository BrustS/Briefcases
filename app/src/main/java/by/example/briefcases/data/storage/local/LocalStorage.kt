package by.example.briefcases.data.storage.local

import androidx.lifecycle.LiveData
import by.example.briefcases.data.entities.AnswerQuestion
import by.example.briefcases.data.entities.Briefcase

interface LocalStorage {
    fun getAllBriefcases(): LiveData<List<Briefcase>>
    suspend fun addNewBriefcase(briefcase: Briefcase)
    fun getQuestionByBriefcase(briefcaseID: String): LiveData<List<AnswerQuestion>>
     suspend fun addQuestionByBriefcase(answerQuestion: AnswerQuestion)
}