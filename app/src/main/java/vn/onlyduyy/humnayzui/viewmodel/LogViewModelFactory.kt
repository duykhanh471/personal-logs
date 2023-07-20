package vn.onlyduyy.humnayzui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import vn.onlyduyy.humnayzui.database.repo.LogRepository
import java.lang.IllegalArgumentException

class LogViewModelFactory(private val logRepository: LogRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LogViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LogViewModel(logRepository) as T
        }
        throw IllegalArgumentException("Error I guess, from Factory")
    }
}