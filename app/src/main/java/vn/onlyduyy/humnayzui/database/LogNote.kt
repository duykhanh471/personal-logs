package vn.onlyduyy.humnayzui.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "log_note")
data class LogNote(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "logTitle")
    var logTitle: String,
    @ColumnInfo(name = "logTime")
    var logTime: String,
    @ColumnInfo(name = "logNote")
    var logNote: String,
)
