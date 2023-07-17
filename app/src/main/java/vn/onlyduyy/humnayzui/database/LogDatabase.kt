package vn.onlyduyy.humnayzui.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LogNote::class], version = 1, exportSchema = false)
abstract class LogDatabase : RoomDatabase() {
    abstract fun getLogDao() : LogDao

    companion object {
        @Volatile
        private var INSTANCE:LogDatabase? = null
        fun getDatabase(context: Context) : LogDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LogDatabase::class.java,
                    "log_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}