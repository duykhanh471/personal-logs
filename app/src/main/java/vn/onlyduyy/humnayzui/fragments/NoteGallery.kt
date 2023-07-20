package vn.onlyduyy.humnayzui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import vn.onlyduyy.humnayzui.R
import vn.onlyduyy.humnayzui.adapter.NoteAdapter
import vn.onlyduyy.humnayzui.database.LogDatabase
import vn.onlyduyy.humnayzui.database.repo.NoteRepository
import vn.onlyduyy.humnayzui.databinding.FragmentNoteGalleryBinding
import vn.onlyduyy.humnayzui.viewmodel.NoteViewModel
import vn.onlyduyy.humnayzui.viewmodel.NoteViewModelFactory

class NoteGallery : Fragment(R.layout.fragment_note_gallery) {
    private lateinit var binding: FragmentNoteGalleryBinding
    private lateinit var noteRepository: NoteRepository
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteGalleryBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //var declare
        val noteDao = LogDatabase.getDatabase(requireContext()).getNoteDao()
        noteRepository = NoteRepository(noteDao)
        val noteFactory = NoteViewModelFactory(noteRepository)
        noteViewModel = ViewModelProvider(this, noteFactory)[NoteViewModel::class.java]
        //display log list
        displayNoteList()
    }

    private fun displayNoteList() {
        noteAdapter = NoteAdapter()
        binding.noteRecView.adapter = noteAdapter
        binding.noteRecView.layoutManager = StaggeredGridLayoutManager(
            2,
            StaggeredGridLayoutManager.VERTICAL
        )
        lastThingTodo()
    }

    private fun lastThingTodo() {
        noteViewModel.getAllNotes().observe(viewLifecycleOwner) {notes->
            notes?.let {
                noteAdapter.submitList(notes)
            }
        }
    }


}
