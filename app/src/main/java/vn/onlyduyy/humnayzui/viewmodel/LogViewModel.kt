package vn.onlyduyy.humnayzui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import vn.onlyduyy.humnayzui.database.LogNote
import vn.onlyduyy.humnayzui.database.LogRepository

class LogViewModel(private val logRepository: LogRepository) : ViewModel() {
    fun addLog(logNote: LogNote) = viewModelScope.launch(Dispatchers.IO) {
        logRepository.insertLog(logNote)
    }

    fun updateLog(logNote: LogNote) = viewModelScope.launch(Dispatchers.IO) {
        logRepository.updateLog(logNote)
    }

    fun deleteLog(logNote: LogNote) = viewModelScope.launch(Dispatchers.IO) {
        logRepository.deleteLog(logNote)
    }

    fun getAllLogs() = logRepository.allLogs
}