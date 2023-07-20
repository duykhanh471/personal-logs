package vn.onlyduyy.humnayzui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import vn.onlyduyy.humnayzui.R
import vn.onlyduyy.humnayzui.databinding.FragmentConfigurationBinding

class Configuration : Fragment(R.layout.fragment_configuration) {
    private lateinit var binding: FragmentConfigurationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConfigurationBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
}