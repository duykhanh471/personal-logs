package vn.onlyduyy.humnayzui.database.repo

import androidx.lifecycle.LiveData
import vn.onlyduyy.humnayzui.database.dao.LogDao
import vn.onlyduyy.humnayzui.database.model.LogData

class LogRepository(private val logDao: LogDao) {
    val allLogs : LiveData<List<LogData>> = logDao.retrieveAllLogs()
    suspend fun insertLog(logData: LogData) {
        logDao.insertLog(logData)
    }
    suspend fun deleteLog(logData: LogData) {
        logDao.deleteLog(logData)
    }
    suspend fun updateLog(logData: LogData) {
        logDao.updateLog(logData)
    }
}