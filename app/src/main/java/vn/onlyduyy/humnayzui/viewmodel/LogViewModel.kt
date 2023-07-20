package vn.onlyduyy.humnayzui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import vn.onlyduyy.humnayzui.database.model.LogData
import vn.onlyduyy.humnayzui.database.repo.LogRepository

class LogViewModel(private val logRepository: LogRepository) : ViewModel() {
    fun addLog(logData: LogData) = viewModelScope.launch(Dispatchers.IO) {
        logRepository.insertLog(logData)
    }
    fun updateLog(logData: LogData) = viewModelScope.launch(Dispatchers.IO) {
        logRepository.updateLog(logData)
    }
    fun deleteLog(logData: LogData) = viewModelScope.launch(Dispatchers.IO) {
        logRepository.deleteLog(logData)
    }
    fun getAllLogs() = logRepository.allLogs
}