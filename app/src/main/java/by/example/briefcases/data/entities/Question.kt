package by.example.briefcases.data.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Questions(
    @Json(name ="questionid")
    val questionID: String,
    @Json(name ="questioncode")
    val questionCode: String,
    @Json(name ="question")
    val question: String,
    @Json(name ="comment")
    var comment: String,
    @Json(name ="categoryid")
    val categoryID: String,
    @Json(name ="origin")
    val origin: String,
    @Json(name ="categorynewid")
    val categoryNewID: String
)