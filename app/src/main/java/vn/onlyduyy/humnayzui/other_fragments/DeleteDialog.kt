package vn.onlyduyy.humnayzui.other_fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import vn.onlyduyy.humnayzui.R
import vn.onlyduyy.humnayzui.database.LogDatabase
import vn.onlyduyy.humnayzui.database.LogNote
import vn.onlyduyy.humnayzui.database.LogRepository
import vn.onlyduyy.humnayzui.databinding.DeleteDialogBinding
import vn.onlyduyy.humnayzui.viewmodel.LogViewModel
import vn.onlyduyy.humnayzui.viewmodel.LogViewModelFactory


class DeleteDialog : DialogFragment() {
    private lateinit var binding: DeleteDialogBinding
    private lateinit var logViewModel: LogViewModel
    private lateinit var logRepository: LogRepository
    private lateinit var currentLog: LogNote
    private val args: DeleteDialogArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DeleteDialogBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Windows layout
        if (dialog != null)
            dialog!!.window!!
                .setLayout(400.toPx(requireContext()), 200.toPx(requireContext()))
        dialog!!.window!!.setTitle(getString(R.string.delete_confirm))

        //init viewModel
        val logDao = LogDatabase.getDatabase(requireContext()).getLogDao()
        logRepository = LogRepository(logDao)
        val logFactory = LogViewModelFactory(logRepository)
        logViewModel = ViewModelProvider(this, logFactory)[LogViewModel::class.java]
        //current note
        currentLog = args.log!!

        binding.confirmButton.setOnClickListener {
            logViewModel.deleteLog(currentLog)
            dismiss()
        }
        binding.dismissButton.setOnClickListener {
            dismiss()
        }
    }

    private fun Int.toPx(context: Context): Int =
        (this * context.resources.displayMetrics.density).toInt()

}