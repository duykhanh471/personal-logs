package vn.onlyduyy.humnayzui.adapter

import androidx.recyclerview.widget.DiffUtil
import vn.onlyduyy.humnayzui.database.model.LogData

class LogComparator : DiffUtil.ItemCallback<LogData>() {
    override fun areItemsTheSame(oldItem: LogData, newItem: LogData): Boolean {
        return oldItem.id == newItem.id
    }
    override fun areContentsTheSame(oldItem: LogData, newItem: LogData): Boolean {
        return oldItem == newItem
    }
}