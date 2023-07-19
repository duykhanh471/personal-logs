package vn.onlyduyy.humnayzui.other_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import vn.onlyduyy.humnayzui.R
import vn.onlyduyy.humnayzui.database.LogDatabase
import vn.onlyduyy.humnayzui.database.LogRepository
import vn.onlyduyy.humnayzui.databinding.FragmentNoteEditBinding
import vn.onlyduyy.humnayzui.viewmodel.LogViewModel
import vn.onlyduyy.humnayzui.viewmodel.LogViewModelFactory


class NoteEdit : Fragment(R.layout.fragment_note_edit) {
    private lateinit var binding: FragmentNoteEditBinding
    private lateinit var logViewModel: LogViewModel
    private lateinit var logRepository: LogRepository
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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //waste some code line here
        val logDao = LogDatabase.getDatabase(requireContext()).getLogDao()
        logRepository = LogRepository(logDao)
        val logFactory = LogViewModelFactory(logRepository)
        logViewModel = ViewModelProvider(this, logFactory)[LogViewModel::class.java]

        binding.noteFab.setOnClickListener {
            saveLog()
        }
    }

    private fun saveLog() {
//        val logTitle = binding.etNote.text.toString().trim()
//        val logText = binding.etNoteText.text.toString().trim()

        // junk code
//        val currentTime = Calendar.getInstance().time
//        val formatter = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
//        val logTime = formatter.format(currentTime)
//
//        if (logTitle.isNotEmpty()) {
//            logViewModel.addLog(LogNote(0, logTitle, logText, logTime))
//            requireView().findNavController().navigate(R.id.action_logEdit2_to_dashboard)
//            Snackbar.make(requireView(), "Success!", Snackbar.LENGTH_SHORT).show()
//        } else {
//            Snackbar.make(requireView(), "Failed to create this log", Snackbar.LENGTH_SHORT).show()
//        }
    }
}