package by.example.briefcases.data.storage.remote

import by.example.briefcases.data.entities.Questionnaires
import by.example.briefcases.data.entities.Questions

interface RemoteStorage {
    suspend fun getCategories(): List<Questionnaires>
    suspend fun getQuestions(qid: Int):List<Questions>
}