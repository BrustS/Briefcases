package by.example.briefcases.data.storage.remote

import by.example.briefcases.data.entities.Questionnaires
import by.example.briefcases.data.entities.Questions
import javax.inject.Inject

class RemoteStorageImp @Inject constructor(private val categoryApi: CategoryApi) :
    RemoteStorage {

    override suspend fun getCategories(): List<Questionnaires> {
        return categoryApi.getCategories()
    }

    override suspend fun getQuestions(qid: Int) : List<Questions> {
        return categoryApi.getQuestions(qid)
    }
}