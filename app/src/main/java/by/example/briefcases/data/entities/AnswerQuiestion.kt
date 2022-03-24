package by.example.briefcases.data.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class AnswerQuestion(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "question_id")
    val questionID: String,
    @ColumnInfo(name = "date_inspection")
    val dateOfInspection: String = "",
    @ColumnInfo(name = "answer")
    val answer: Int = 0,
    @ColumnInfo(name = "question_code")
    val questionCode: String,
    @ColumnInfo(name = "question")
    val question: String,
    @ColumnInfo(name = "comment_question")
    val commentForQuestion: String = "",
    @ColumnInfo(name = "category_id")
    val categoryID: String,
    @ColumnInfo(name = "origin")
    val origin: String,
    @ColumnInfo(name = "category_newid")
    val categoryNewID: String,
    @ColumnInfo(name = "isanswered")
    val isAnswered: Boolean = false,
    @ColumnInfo(name = "briefcase_id")
    val briefcaseId: String
)