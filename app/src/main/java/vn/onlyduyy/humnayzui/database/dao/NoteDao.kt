package vn.onlyduyy.humnayzui.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import vn.onlyduyy.humnayzui.database.model.NoteData

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note: NoteData)
    @Delete
    suspend fun deleteNote(note: NoteData)
    @Update
    suspend fun updateNote(note: NoteData)
    @Query("select * from note_table")
    fun retrieveAllNotes() : LiveData<List<NoteData>>
}