package vn.onlyduyy.humnayzui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import vn.onlyduyy.humnayzui.database.model.NoteData
import vn.onlyduyy.humnayzui.database.repo.NoteRepository

class NoteViewModel(private val noteRepository: NoteRepository) : ViewModel() {
    fun insertNote(note: NoteData) = viewModelScope.launch(Dispatchers.IO){
        noteRepository.insertNote(note)
    }
    fun deleteNote(note: NoteData) = viewModelScope.launch(Dispatchers.IO){
        noteRepository.deleteNote(note)
    }
    fun updateNote(note: NoteData) = viewModelScope.launch(Dispatchers.IO){
        noteRepository.updateNote(note)
    }
    fun getAllNotes() = noteRepository.allNotes
}