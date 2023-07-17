package vn.onlyduyy.humnayzui.database

import androidx.lifecycle.LiveData

class LogRepository(private val logDao: LogDao) {
    val allLogs : LiveData<List<LogNote>> = logDao.retrieveAllLogs()
    suspend fun insertLog(logNote: LogNote) {
        logDao.insertLog(logNote)
    }
    suspend fun deleteLog(logNote: LogNote) {
        logDao.deleteLog(logNote)
    }
    suspend fun updateLog(logNote: LogNote) {
        logDao.updateLog(logNote)
    }
}