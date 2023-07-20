package vn.onlyduyy.humnayzui.adapter

import androidx.recyclerview.widget.RecyclerView
import vn.onlyduyy.humnayzui.database.model.NoteData
import vn.onlyduyy.humnayzui.databinding.NoteCardBinding

class NoteVH(private val noteBinding: NoteCardBinding) : RecyclerView.ViewHolder(noteBinding.root) {
    fun bind(note: NoteData) {
        noteBinding.tvNoteTitle.text = note.noteTitle
        noteBinding.noteContent.text = note.noteContent
    }
}