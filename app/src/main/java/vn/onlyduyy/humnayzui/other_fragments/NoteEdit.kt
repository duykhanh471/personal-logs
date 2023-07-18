package vn.onlyduyy.humnayzui.other_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import vn.onlyduyy.humnayzui.R
import vn.onlyduyy.humnayzui.databinding.FragmentNoteEditBinding

class NoteEdit : Fragment(R.layout.fragment_note_edit) {
    private lateinit var binding: FragmentNoteEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteEditBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
}