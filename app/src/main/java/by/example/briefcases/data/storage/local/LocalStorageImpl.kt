package by.example.briefcases.data.storage.local

import androidx.lifecycle.LiveData
import by.example.briefcases.data.entities.AnswerQuestion
import by.example.briefcases.data.entities.Briefcase
import javax.inject.Inject


class LocalStorageImpl @Inject constructor(private val localDAO: LocalDAO) : LocalStorage {
    override  fun getAllBriefcases(): LiveData<List<Briefcase>> {
        return localDAO.getAllBriefcases()
    }

    override suspend fun getAnswerByBriefcase(): List<AnswerQuestion> {
        TODO("Not yet implemented")
    }

    override suspend fun addNewBriefcase(briefcase: Briefcase) {
        localDAO.addNewBriefcase(briefcase)
    }

    override  fun getQuestionByBriefcase(briefcaseID: String): LiveData<List<AnswerQuestion>> {
        return localDAO.getQuestionsByBriefcase(briefcaseID = briefcaseID)
    }

    override  suspend fun addQuestionByBriefcase(answerQuestion: AnswerQuestion) {
        localDAO.addQuestions(answerQuestion)
    }
}