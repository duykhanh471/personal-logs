package vn.onlyduyy.humnayzui.database.repo

import vn.onlyduyy.humnayzui.database.dao.NoteDao
import vn.onlyduyy.humnayzui.database.model.NoteData

class NoteRepository(private val noteDao: NoteDao) {
    val allNotes = noteDao.retrieveAllNotes()

    suspend fun insertNote(note: NoteData) {
        noteDao.insertNote(note)
    }
    suspend fun deleteNote(note: NoteData) {
        noteDao.deleteNote(note)
    }
    suspend fun updateNote(note: NoteData) {
        noteDao.updateNote(note)
    }
}