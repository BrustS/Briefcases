package by.example.briefcases.data.storage.remote

import by.example.briefcases.data.entities.Questionnaires
import by.example.briefcases.data.entities.Questions
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface CategoryApi {
    companion object {
        const val BASE_URL = "http://dev.eraappmobile.com"
    }

    @GET("api/question")
    suspend fun getCategories(): List<Questionnaires>

    @FormUrlEncoded
    @POST("api/question")
    suspend fun getQuestions(
        @Field("qid") qid: Int
    ): List<Questions>
}