package vn.onlyduyy.humnayzui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import vn.onlyduyy.humnayzui.R
import vn.onlyduyy.humnayzui.adapter.LogAdapter
import vn.onlyduyy.humnayzui.database.LogDatabase
import vn.onlyduyy.humnayzui.database.LogRepository
import vn.onlyduyy.humnayzui.databinding.FragmentDashboardBinding
import vn.onlyduyy.humnayzui.viewmodel.LogViewModel
import vn.onlyduyy.humnayzui.viewmodel.LogViewModelFactory

class Dashboard : Fragment(R.layout.fragment_dashboard) {
    private lateinit var binding: FragmentDashboardBinding
    private lateinit var logAdapter: LogAdapter
    private lateinit var logRepository: LogRepository
    private lateinit var logViewModel: LogViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //var declare
        val logDao = LogDatabase.getDatabase(requireContext()).getLogDao()
        logRepository = LogRepository(logDao)
        val logFactory = LogViewModelFactory(logRepository)
        logViewModel = ViewModelProvider(this, logFactory)[LogViewModel::class.java]
        //display log list
        displayLogList()
    }

    private fun displayLogList() {
        logAdapter = LogAdapter()
        binding.logRecView.adapter = logAdapter
        binding.logRecView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        lastThingTodo()
    }

    private fun lastThingTodo() {
        logViewModel.getAllLogs().observe(viewLifecycleOwner) {logs ->
            logs?.let {
                logAdapter.submitList(logs)
            }

        }
    }


}