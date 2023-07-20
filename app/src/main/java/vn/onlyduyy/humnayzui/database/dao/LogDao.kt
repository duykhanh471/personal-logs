package vn.onlyduyy.humnayzui.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import vn.onlyduyy.humnayzui.database.model.LogData

@Dao
interface LogDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLog(logData: LogData)
    @Update
    suspend fun updateLog(logData: LogData)
    @Delete
    suspend fun deleteLog(logData: LogData)
    @Query("select * from log_table")
    fun retrieveAllLogs() : LiveData<List<LogData>>
}