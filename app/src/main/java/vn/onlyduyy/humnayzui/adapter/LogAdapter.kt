package vn.onlyduyy.humnayzui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import vn.onlyduyy.humnayzui.database.model.LogData
import vn.onlyduyy.humnayzui.databinding.LogCardBinding
import vn.onlyduyy.humnayzui.fragments.DashboardDirections

class LogAdapter : ListAdapter<LogData, LogVH>(LogComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogVH {
        return LogVH(LogCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: LogVH, position: Int) {
        val currentItem = getItem(position)
        holder.bind((currentItem as LogData))

        holder.itemView.setOnLongClickListener {
            val homeDirection = DashboardDirections.actionDashboardToDeleteDialog(currentItem)
            it.findNavController().navigate(homeDirection)
            true
        }
    }

}