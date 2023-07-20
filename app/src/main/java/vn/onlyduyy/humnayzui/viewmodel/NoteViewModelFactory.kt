package vn.onlyduyy.humnayzui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import vn.onlyduyy.humnayzui.database.repo.NoteRepository
import java.lang.IllegalArgumentException

class NoteViewModelFactory(private val noteRepository: NoteRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NoteViewModel(noteRepository) as T
        }
       throw IllegalArgumentException("ViewModel not found")
    }
}