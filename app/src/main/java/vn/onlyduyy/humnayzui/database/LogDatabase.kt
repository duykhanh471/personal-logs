package vn.onlyduyy.humnayzui.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import vn.onlyduyy.humnayzui.database.dao.LogDao
import vn.onlyduyy.humnayzui.database.dao.NoteDao
import vn.onlyduyy.humnayzui.database.model.LogData
import vn.onlyduyy.humnayzui.database.model.NoteData

@Database(entities = [LogData::class, NoteData::class], version = 1, exportSchema = false)
abstract class LogDatabase : RoomDatabase() {
    abstract fun getLogDao() : LogDao
    abstract fun getNoteDao() : NoteDao
    companion object {
        @Volatile
        private var INSTANCE:LogDatabase? = null
        fun getDatabase(context: Context) : LogDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LogDatabase::class.java,
                    "personal_logs"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}