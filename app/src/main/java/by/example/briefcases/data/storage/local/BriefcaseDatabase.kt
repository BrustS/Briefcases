package by.example.briefcases.data.storage.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.example.briefcases.data.entities.AnswerQuestion
import by.example.briefcases.data.entities.Briefcase

@Database(entities = arrayOf(Briefcase::class, AnswerQuestion::class), version = 1)
abstract class BriefcaseDataBase : RoomDatabase() {
    abstract fun localDAO(): LocalDAO

    companion object {
        @Volatile
        private var INSTANCE: BriefcaseDataBase? = null

        @Synchronized
        fun getBriefcaseDatabase(context: Context) : BriefcaseDataBase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    BriefcaseDataBase::class.java,
                    "briefcase.db").build()
            }
            return INSTANCE!!
        }
    }

}