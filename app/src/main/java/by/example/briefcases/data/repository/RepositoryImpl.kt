package by.example.briefcases.data.repository

import androidx.lifecycle.LiveData
import by.example.briefcases.data.entities.AnswerQuestion
import by.example.briefcases.data.entities.Briefcase
import by.example.briefcases.data.entities.Questionnaires
import by.example.briefcases.data.entities.Questions
import by.example.briefcases.data.storage.local.LocalStorage
import by.example.briefcases.data.storage.remote.RemoteStorage
import by.example.briefcases.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val localStorage: LocalStorage,
                                         private val remoteStorage: RemoteStorage
): Repository {
    override fun getAllBriefcases(): LiveData<List<Briefcase>> {
       return localStorage.getAllBriefcases()
    }

    override suspend fun addNewBriefcase(briefcase: Briefcase) {
       localStorage.addNewBriefcase(briefcase)
    }

    override fun getQuestionByBriefcase(briefcaseID: String): LiveData<List<AnswerQuestion>> {
        return localStorage.getQuestionByBriefcase(briefcaseID)
    }

    override suspend fun getCategories(): List<Questionnaires> {
        return remoteStorage.getCategories()
    }

    override suspend fun getQuestions(qid: Int): List<Questions> {
       return remoteStorage.getQuestions(qid)
    }

    override suspend fun addQuestionToLocal(answerQuestion: AnswerQuestion) {
       localStorage.addQuestionByBriefcase(answerQuestion)
    }

}