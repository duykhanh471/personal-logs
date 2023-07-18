package vn.onlyduyy.humnayzui.other_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import vn.onlyduyy.humnayzui.R
import vn.onlyduyy.humnayzui.database.LogDatabase
import vn.onlyduyy.humnayzui.database.LogNote
import vn.onlyduyy.humnayzui.database.LogRepository
import vn.onlyduyy.humnayzui.databinding.FragmentLogEditBinding
import vn.onlyduyy.humnayzui.viewmodel.LogViewModel
import vn.onlyduyy.humnayzui.viewmodel.LogViewModelFactory
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class LogEdit : Fragment(R.layout.fragment_log_edit) {
    private lateinit var binding: FragmentLogEditBinding
    private lateinit var logViewModel: LogViewModel
    private lateinit var logRepository: LogRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogEditBinding.inflate(inflater, container, false)
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

        binding.logFab.setOnClickListener {
            saveLog()
            it.findNavController().navigate(R.id.action_logEdit2_to_dashboard)
        }
    }

    private fun saveLog() {
        val logTitle = binding.etLog.text.toString().trim()
        val logText = binding.etLogNote.text.toString().trim()

        // junk code
        val currentTime = Calendar.getInstance().time
        val formatter = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
        val logTime = formatter.format(currentTime)

        if (logTitle.isNotEmpty()) {
            logViewModel.addLog(LogNote(0, logTitle, logText, logTime))
            Snackbar.make(requireView(), "Success!", Snackbar.LENGTH_SHORT).show()
        } else {
            Snackbar.make(requireView(), "Failed to create this log", Snackbar.LENGTH_SHORT).show()
        }
    }
}