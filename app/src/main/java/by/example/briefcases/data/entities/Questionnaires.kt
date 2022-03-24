package by.example.briefcases.data.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Questionnaires(
    @Json(name = "qid")
    val id: Int,
    @Json(name = "title")
    val title: String)