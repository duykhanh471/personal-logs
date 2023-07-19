package vn.onlyduyy.humnayzui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import vn.onlyduyy.humnayzui.R
import vn.onlyduyy.humnayzui.database.LogNote
import vn.onlyduyy.humnayzui.fragments.DashboardDirections

class LogAdapter() : ListAdapter<LogNote, LogViewHolder>(LogComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.log_card, parent, false)
        return LogViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: LogViewHolder, position: Int) {
        val currentNote = getItem(position)
        holder.bind(currentNote)

        holder.itemView.setOnLongClickListener {
            val homeDirection = DashboardDirections.actionDashboardToDeleteDialog(currentNote)
            it.findNavController().navigate(homeDirection)
            true
        }
    }

}