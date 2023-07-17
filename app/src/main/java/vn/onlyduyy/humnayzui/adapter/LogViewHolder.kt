package vn.onlyduyy.humnayzui.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vn.onlyduyy.humnayzui.R
import vn.onlyduyy.humnayzui.database.LogNote

class LogViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView){
    private val titleText: TextView = itemView.findViewById(R.id.tvTitle)
    private val logText: TextView = itemView.findViewById(R.id.logText)
    private val logTime: TextView = itemView.findViewById(R.id.tvDateTime)
    fun bind(logNote: LogNote) {
        titleText.text = logNote.logTitle
        logText.text = logNote.logNote
        logTime.text = logNote.logTime
    }
}