package vn.onlyduyy.humnayzui.database.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "note_table")
@Parcelize
data class NoteData(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "noteTitle")
    var noteTitle: String,
    @ColumnInfo(name = "noteContent")
    var noteContent: String,
) : Parcelable