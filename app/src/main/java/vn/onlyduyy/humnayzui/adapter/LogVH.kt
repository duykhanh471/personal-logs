package vn.onlyduyy.humnayzui.adapter

import androidx.recyclerview.widget.RecyclerView
import vn.onlyduyy.humnayzui.database.model.LogData
import vn.onlyduyy.humnayzui.databinding.LogCardBinding


class LogVH(private val logBinding: LogCardBinding) : RecyclerView.ViewHolder(logBinding.root) {
    fun bind(logData: LogData) {
        logBinding.tvTitle.text = logData.logTitle
        logBinding.logText.text = logData.logNote
        logBinding.tvDateTime.text = logData.logTime
    }
}
