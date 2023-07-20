package vn.onlyduyy.humnayzui.database.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "log_table")
@Parcelize
data class LogData(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "logTitle")
    var logTitle: String,
    @ColumnInfo(name = "logTime")
    var logTime: String,
    @ColumnInfo(name = "logNote")
    var logNote: String,
) : Parcelable