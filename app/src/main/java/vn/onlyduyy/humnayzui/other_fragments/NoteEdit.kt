package vn.onlyduyy.humnayzui.other_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import vn.onlyduyy.humnayzui.R
import vn.onlyduyy.humnayzui.database.LogDatabase
import vn.onlyduyy.humnayzui.database.model.NoteData
import vn.onlyduyy.humnayzui.database.repo.NoteRepository
import vn.onlyduyy.humnayzui.databinding.NoteEditBinding
import vn.onlyduyy.humnayzui.viewmodel.NoteViewModel
import vn.onlyduyy.humnayzui.viewmodel.NoteViewModelFactory


class NoteEdit : Fragment(R.layout.note_edit) {
    private lateinit var binding: NoteEditBinding
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var noteRepository: NoteRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NoteEditBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //waste some code line here
        val noteDao = LogDatabase.getDatabase(requireContext()).getNoteDao()
        noteRepository = NoteRepository(noteDao)
        val noteFactory = NoteViewModelFactory(noteRepository)
        noteViewModel = ViewModelProvider(this, noteFactory)[NoteViewModel::class.java]

        binding.noteFab.setOnClickListener {
            saveNote()
        }
    }

    private fun saveNote() {
        val noteTitle = binding.etNote.text.toString().trim()
        val noteContent = binding.etNoteText.text.toString().trim()


        if (noteTitle.isNotEmpty()) {
            noteViewModel.insertNote(NoteData(0, noteTitle, noteContent))
            requireView().findNavController().navigate(R.id.action_noteEdit_to_noteGallery)
            Snackbar.make(requireView(), "Success!", Snackbar.LENGTH_SHORT).show()
        } else {
            Snackbar.make(requireView(), "Failed to create this log", Snackbar.LENGTH_SHORT).show()
        }
    }
}