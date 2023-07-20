package vn.onlyduyy.humnayzui.adapter

import androidx.recyclerview.widget.DiffUtil
import vn.onlyduyy.humnayzui.database.model.NoteData

class NoteComparator : DiffUtil.ItemCallback<NoteData>() {
    override fun areItemsTheSame(oldItem: NoteData, newItem: NoteData): Boolean {
        return oldItem.id == newItem.id
    }
    override fun areContentsTheSame(oldItem: NoteData, newItem: NoteData): Boolean {
        return oldItem == newItem
    }
}