package vn.onlyduyy.humnayzui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import vn.onlyduyy.humnayzui.R
import vn.onlyduyy.humnayzui.databinding.SettingsFragmentBinding

class Configuration : Fragment(R.layout.settings_fragment) {
    private lateinit var binding: SettingsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SettingsFragmentBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
}