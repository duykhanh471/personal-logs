package vn.onlyduyy.humnayzui.adapter

import androidx.recyclerview.widget.DiffUtil
import vn.onlyduyy.humnayzui.database.LogNote

class LogComparator : DiffUtil.ItemCallback<LogNote>() {
    override fun areItemsTheSame(oldItem: LogNote, newItem: LogNote): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: LogNote, newItem: LogNote): Boolean {
        return oldItem.logTitle == newItem.logTitle &&
        oldItem.logNote == newItem.logNote
    }
}