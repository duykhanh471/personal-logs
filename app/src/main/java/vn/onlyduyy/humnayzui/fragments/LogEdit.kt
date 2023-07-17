package vn.onlyduyy.humnayzui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import vn.onlyduyy.humnayzui.R
import vn.onlyduyy.humnayzui.databinding.FragmentLogEditBinding

class LogEdit : Fragment(R.layout.fragment_log_edit) {
    private lateinit var binding: FragmentLogEditBinding
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
}