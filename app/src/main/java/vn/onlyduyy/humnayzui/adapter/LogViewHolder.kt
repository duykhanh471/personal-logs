package vn.onlyduyy.humnayzui.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vn.onlyduyy.humnayzui.R
import vn.onlyduyy.humnayzui.database.LogNote

class LogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val titleText: TextView = itemView.findViewById(R.id.tvTitle)
    private val logTime: TextView = itemView.findViewById(R.id.tvDateTime)
    private val logText: TextView = itemView.findViewById(R.id.logText)

    fun bind(logNote: LogNote) {
        titleText.text = logNote.logTitle
        logTime.text = logNote.logTime
        logText.text = logNote.logNote
    }
}