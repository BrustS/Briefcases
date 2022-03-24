package by.example.briefcases.data.storage.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import by.example.briefcases.data.entities.AnswerQuestion
import by.example.briefcases.data.entities.Briefcase

@Dao
interface LocalDAO {
    @Query("SELECT * FROM briefcases")
    fun getAllBriefcases(): LiveData<List<Briefcase>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNewBriefcase(newItem: Briefcase)

    @Query("SELECT * FROM questions WHERE questions.briefcase_id = :briefcaseID")
    fun getQuestionsByBriefcase(briefcaseID: String) : LiveData<List<AnswerQuestion>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuestions(answerQuestion: AnswerQuestion)

}