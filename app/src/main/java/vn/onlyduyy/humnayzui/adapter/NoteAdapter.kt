package vn.onlyduyy.humnayzui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import vn.onlyduyy.humnayzui.database.model.NoteData
import vn.onlyduyy.humnayzui.databinding.NoteCardBinding
import vn.onlyduyy.humnayzui.other_fragments.NoteEditDirections

class NoteAdapter : ListAdapter<NoteData, NoteVH>(NoteComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteVH {
        return NoteVH(NoteCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NoteVH, position: Int) {
        val currentItem = getItem(position)
        holder.bind((currentItem as NoteData))

        holder.itemView.setOnLongClickListener {
            val noteDirections = NoteEditDirections.actionNoteEditToNoteGallery()
            it.findNavController().navigate(noteDirections)
            true
        }
    }

}