package vn.onlyduyy.humnayzui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import vn.onlyduyy.humnayzui.R
import vn.onlyduyy.humnayzui.databinding.IdeaSpacesBinding

class Spaces : Fragment(R.layout.idea_spaces) {
    private lateinit var binding: IdeaSpacesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = IdeaSpacesBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.firstLogCard.setOnClickListener {
            it.findNavController().navigate(R.id.action_spaces_to_logEdit2)
        }
        binding.secondNoteCard.setOnClickListener {
            it.findNavController().navigate(R.id.action_spaces_to_noteEdit)
        }
    }
}