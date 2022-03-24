package by.example.briefcases.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "briefcases")
data class Briefcase(
    @PrimaryKey(autoGenerate = false)
    val dateOfCreation: String = Calendar.getInstance().time.toString(),
    @ColumnInfo(name = "vessel")
    val vessel: String,
    @ColumnInfo(name = "port")
    val port: String,
    @ColumnInfo(name = "inspectiontype")
    val inspectionType: String,
    @ColumnInfo(name = "inspectionsource")
    val inspectionSource: String,
    @ColumnInfo(name = "inspectorname")
    val inspectorName: String,
    @ColumnInfo(name = "category")
    val category: String
)