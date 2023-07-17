package vn.onlyduyy.humnayzui.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface LogDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLog(logNote: LogNote)
    @Update
    suspend fun updateLog(logNote: LogNote)
    @Delete
    suspend fun deleteLog(logNote: LogNote)
    @Query("select * from log_note")
    fun retrieveAllLogs() : LiveData<List<LogNote>>
}